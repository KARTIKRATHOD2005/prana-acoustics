package com.prana.acoustics.patient.model

data class Patient(
    val fullName: String,
    val age: String,
    val gender: String,
    val village: String,
    val mobileNumber: String,
    val abhaId: String,
    val address: String,
    val emergencyContact: String
)