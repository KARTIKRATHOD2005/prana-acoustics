package com.prana.acoustics.patient.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun VitalSignsCard() {
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var temperature by remember { mutableStateOf("") }
    var pulse by remember { mutableStateOf("") }
    var spo2 by remember { mutableStateOf("") }
    var bp by remember { mutableStateOf("") }

    val bmi = calculateBmi(height, weight)

    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text("❤️ Vital Signs", style = MaterialTheme.typography.titleLarge)

            PatientInputNumber("Height (cm)", height) { height = it }
            PatientInputNumber("Weight (kg)", weight) { weight = it }

            if (bmi.isNotEmpty()) {
                Spacer(modifier = Modifier.height(12.dp))
                AssistChip(
                    onClick = {},
                    label = { Text("BMI: $bmi") }
                )
            }

            PatientInputNumber("Temperature (°C)", temperature) { temperature = it }
            PatientInputNumber("Pulse Rate", pulse) { pulse = it }
            PatientInputNumber("SpO₂ (%)", spo2) { spo2 = it }

            PatientInput("Blood Pressure", bp) { bp = it }
        }
    }
}

@Composable
fun PatientInputNumber(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    PatientInput(
        label = label,
        value = value,
        keyboardType = KeyboardType.Number,
        onValueChange = {
            if (it.all { c -> c.isDigit() || c == '.' }) {
                onValueChange(it)
            }
        }
    )
}

fun calculateBmi(heightCm: String, weightKg: String): String {
    val height = heightCm.toFloatOrNull()
    val weight = weightKg.toFloatOrNull()

    if (height == null || weight == null || height <= 0) return ""

    val heightMeters = height / 100
    val bmi = weight / (heightMeters * heightMeters)

    return ((bmi * 10).roundToInt() / 10.0).toString()
}