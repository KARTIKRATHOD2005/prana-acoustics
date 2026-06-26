package com.prana.acoustics.patient.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MedicalHistoryCard() {
    val history = listOf("Diabetes", "Hypertension", "Asthma", "Heart Disease")
    val selected = remember { mutableStateListOf<String>() }

    Card(shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text("🧬 Medical History", style = MaterialTheme.typography.titleLarge)

            history.forEach { item ->
                Row {
                    Checkbox(
                        checked = selected.contains(item),
                        onCheckedChange = {
                            if (it) selected.add(item) else selected.remove(item)
                        }
                    )
                    Text(item, modifier = Modifier.padding(top = 12.dp))
                }
            }
        }
    }
}