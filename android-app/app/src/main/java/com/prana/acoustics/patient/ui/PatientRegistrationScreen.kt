package com.prana.acoustics.patient.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PatientRegistrationScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Text(
            text = "Register Patient",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        PersonalInfoCard()

        Spacer(modifier = Modifier.height(16.dp))

        VitalSignsCard()

        Spacer(modifier = Modifier.height(16.dp))

        SymptomsCard()

        Spacer(modifier = Modifier.height(16.dp))

        MedicalHistoryCard()

        Spacer(modifier = Modifier.height(16.dp))

        AudioRecordingCard()

        Spacer(modifier = Modifier.height(24.dp))

        BottomButtons()

        Spacer(modifier = Modifier.height(30.dp))
    }
}