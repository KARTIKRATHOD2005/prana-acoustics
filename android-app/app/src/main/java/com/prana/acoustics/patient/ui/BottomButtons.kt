package com.prana.acoustics.patient.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomButtons() {
    var saved by remember { mutableStateOf(false) }

    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedButton(
                onClick = { saved = true },
                modifier = Modifier.weight(1f)
            ) {
                Text("Save Offline")
            }

            Spacer(modifier = Modifier.width(12.dp))

            Button(
                onClick = { saved = true },
                modifier = Modifier.weight(1f)
            ) {
                Text("Analyze")
            }
        }

        if (saved) {
            Spacer(modifier = Modifier.height(12.dp))
            AssistChip(
                onClick = {},
                label = { Text("Saved locally. Ready for sync later.") }
            )
        }
    }
}