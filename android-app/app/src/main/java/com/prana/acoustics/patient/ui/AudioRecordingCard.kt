package com.prana.acoustics.patient.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AudioRecordingCard() {
    Card(shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text("🎤 AI Audio Screening", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.height(12.dp))

            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                Text("Record Cough")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                Text("Record Breathing")
            }
        }
    }
}