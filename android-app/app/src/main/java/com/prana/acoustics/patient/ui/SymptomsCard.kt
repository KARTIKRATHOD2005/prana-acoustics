package com.prana.acoustics.patient.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SymptomsCard() {
    val symptoms = listOf("Fever", "Cough", "Breathlessness", "Chest Pain", "Fatigue")
    val selected = remember { mutableStateListOf<String>() }

    Card(shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text("🩺 Symptoms", style = MaterialTheme.typography.titleLarge)

            symptoms.forEach { symptom ->
                Row {
                    Checkbox(
                        checked = selected.contains(symptom),
                        onCheckedChange = {
                            if (it) selected.add(symptom) else selected.remove(symptom)
                        }
                    )
                    Text(symptom, modifier = Modifier.padding(top = 12.dp))
                }
            }
        }
    }
}