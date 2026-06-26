package com.prana.acoustics.patient.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomButtons() {
    Row(modifier = Modifier.fillMaxWidth()) {
        OutlinedButton(
            onClick = {},
            modifier = Modifier.weight(1f)
        ) {
            Text("Save Offline")
        }

        Spacer(modifier = Modifier.width(12.dp))

        Button(
            onClick = {},
            modifier = Modifier.weight(1f)
        ) {
            Text("Analyze")
        }
    }
}