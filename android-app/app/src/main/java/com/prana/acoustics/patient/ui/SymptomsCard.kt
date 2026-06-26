package com.prana.acoustics.patient.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SymptomsCard() {
    val symptoms = listOf(
        "Fever",
        "Cough",
        "Cold",
        "Breathlessness",
        "Chest Pain",
        "Fatigue",
        "Wheezing",
        "Weight Loss"
    )

    val selectedSymptoms = remember { mutableStateListOf<String>() }

    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {

            Text(
                text = "🩺 Symptoms",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Select all symptoms observed during visit",
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                symptoms.forEach { symptom ->
                    val selected = selectedSymptoms.contains(symptom)

                    FilterChip(
                        selected = selected,
                        onClick = {
                            if (selected) {
                                selectedSymptoms.remove(symptom)
                            } else {
                                selectedSymptoms.add(symptom)
                            }
                        },
                        label = {
                            Text(symptom)
                        }
                    )
                }
            }

            if (selectedSymptoms.isNotEmpty()) {
                Spacer(modifier = Modifier.height(16.dp))

                AssistChip(
                    onClick = {},
                    label = {
                        Text("${selectedSymptoms.size} symptom(s) selected")
                    }
                )
            }
        }
    }
}