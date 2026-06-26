package com.prana.acoustics.patient.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VitalSignsCard() {
    var temperature by remember { mutableStateOf("") }
    var pulse by remember { mutableStateOf("") }
    var spo2 by remember { mutableStateOf("") }
    var bp by remember { mutableStateOf("") }

    Card(shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text("❤️ Vital Signs", style = MaterialTheme.typography.titleLarge)

            PatientInput("Temperature", temperature) { temperature = it }
            PatientInput("Pulse Rate", pulse) { pulse = it }
            PatientInput("SpO₂", spo2) { spo2 = it }
            PatientInput("Blood Pressure", bp) { bp = it }
        }
    }
}