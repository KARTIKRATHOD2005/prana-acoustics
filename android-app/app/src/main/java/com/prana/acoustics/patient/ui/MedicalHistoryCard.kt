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
fun MedicalHistoryCard() {
    val conditions = listOf(
        "Diabetes",
        "Hypertension",
        "Asthma",
        "Heart Disease",
        "Tuberculosis",
        "Smoking",
        "Alcohol"
    )

    val selectedConditions = remember { mutableStateListOf<String>() }

    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "🧬 Medical History",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Select known conditions or lifestyle risks",
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                conditions.forEach { condition ->
                    val selected = selectedConditions.contains(condition)

                    FilterChip(
                        selected = selected,
                        onClick = {
                            if (selected) {
                                selectedConditions.remove(condition)
                            } else {
                                selectedConditions.add(condition)
                            }
                        },
                        label = { Text(condition) }
                    )
                }
            }

            if (selectedConditions.isNotEmpty()) {
                Spacer(modifier = Modifier.height(16.dp))

                AssistChip(
                    onClick = {},
                    label = {
                        Text("${selectedConditions.size} item(s) selected")
                    }
                )
            }
        }
    }
}