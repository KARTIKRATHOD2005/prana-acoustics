from fastapi import FastAPI, Depends
from pydantic import BaseModel
from typing import List, Optional
import datetime

# --- DATABASE SETUP ---
from sqlalchemy import create_engine, Column, Integer, String, Float, DateTime
from sqlalchemy.orm import declarative_base, sessionmaker, Session

# This creates a file called 'prana.db' to permanently save data
SQLALCHEMY_DATABASE_URL = "sqlite:///./prana.db"
engine = create_engine(SQLALCHEMY_DATABASE_URL, connect_args={"check_same_thread": False})
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)
Base = declarative_base()

# 1. Database Table Schema (How data is saved to the hard drive)
class DBPatientRecord(Base):
    _tablename_ = "patients"
    
    id = Column(Integer, primary_key=True, index=True)
    asha_id = Column(String, index=True)
    patient_name = Column(String)
    age = Column(Integer)
    gender = Column(String)
    location_village = Column(String)
    ai_priority = Column(String, index=True) # Green, Yellow, Red
    cough_audio_duration_seconds = Column(Float)
    spo2_level = Column(Integer, nullable=True)
    timestamp = Column(DateTime, default=datetime.datetime.utcnow)

# Create the tables in the database file
Base.metadata.create_all(bind=engine)

# --- FASTAPI SETUP ---
app = FastAPI(title="Project Prana-Acoustics Backend")

# 2. Pydantic Model (Validates incoming data from Android)
class PatientRecord(BaseModel):
    asha_id: str
    patient_name: str
    age: int
    gender: str
    location_village: str
    ai_priority: str
    cough_audio_duration_seconds: float
    spo2_level: Optional[int] = None

# Helper to get the database session
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

# 3. ENDPOINTS

@app.get("/")
def read_root():
    return {"status": "Online", "database": "Connected to SQLite"}

@app.post("/sync")
def sync_records(records: List[PatientRecord], db: Session = Depends(get_db)):
    """Receives offline data from the Android app and saves it permanently."""
    saved_count = 0
    
    for record in records:
        # Convert incoming JSON data to a Database Object
        db_patient = DBPatientRecord(
            asha_id=record.asha_id,
            patient_name=record.patient_name,
            age=record.age,
            gender=record.gender,
            location_village=record.location_village,
            ai_priority=record.ai_priority,
            cough_audio_duration_seconds=record.cough_audio_duration_seconds,
            spo2_level=record.spo2_level
        )
        # Add to database queue
        db.add(db_patient)
        
        # Trigger an alert if the AI caught a critical issue
        if record.ai_priority == "Red":
             print(f"CRITICAL ALERT: Emergency case for {record.patient_name} in {record.location_village}")
             
        saved_count += 1
        
    db.commit() # Save everything to the prana.db file
    return {"message": "Sync successful", "records_saved_to_db": saved_count}

@app.get("/doctor/dashboard")
def get_doctor_dashboard(priority: Optional[str] = None, db: Session = Depends(get_db)):
    """Fetches records for the doctor to review."""
    if priority:
        # Filter by priority (e.g., show only 'Red' or 'Yellow' cases)
        cases = db.query(DBPatientRecord).filter(DBPatientRecord.ai_priority == priority).all()
    else:
        # Show all patients
        cases = db.query(DBPatientRecord).all()
    return cases