package com.prana.acoustics.patient.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AudioRecordingCard() {
    var coughRecorded by remember { mutableStateOf(false) }
    var breathingRecorded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text("🎤 AI Audio Screening", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Record cough and breathing sounds for AI-assisted triage.",
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { coughRecorded = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (coughRecorded) "✅ Cough Recorded" else "Record Cough")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { breathingRecorded = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (breathingRecorded) "✅ Breathing Recorded" else "Record Breathing")
            }
        }
    }
}