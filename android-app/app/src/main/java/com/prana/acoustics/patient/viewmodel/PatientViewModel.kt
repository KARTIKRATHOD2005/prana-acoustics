package com.prana.acoustics.patient.viewmodel

import com.prana.acoustics.patient.model.Patient
import com.prana.acoustics.patient.repository.PatientRepository

class PatientViewModel {

    private val repository = PatientRepository()

    fun savePatient(patient: Patient): Boolean {
        return repository.savePatient(patient)
    }
}