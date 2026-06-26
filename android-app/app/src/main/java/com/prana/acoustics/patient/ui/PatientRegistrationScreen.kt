package com.prana.acoustics.patient.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PatientRegistrationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFFE3F2FD), Color.White)
                )
            )
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "Register Patient",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0D47A1)
        )

        Text(
            text = "Step 1 of 6 • Offline-first triage record",
            style = MaterialTheme.typography.bodySmall,
            color = Color(0xFF607D8B)
        )

        Spacer(modifier = Modifier.height(12.dp))

        LinearProgressIndicator(
            progress = { 0.35f },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        PersonalInfoCard()

        Spacer(modifier = Modifier.height(16.dp))

        VitalSignsCard()

        Spacer(modifier = Modifier.height(16.dp))

        SymptomsCard()

        Spacer(modifier = Modifier.height(16.dp))

        MedicalHistoryCard()

        Spacer(modifier = Modifier.height(16.dp))

        AudioRecordingCard()

        Spacer(modifier = Modifier.height(20.dp))

        BottomButtons()

        Spacer(modifier = Modifier.height(32.dp))
    }
}