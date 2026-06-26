package com.prana.acoustics.patient.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalInfoCard() {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var village by remember { mutableStateOf("") }
    var mobile by remember { mutableStateOf("") }

    val genders = listOf("Male", "Female", "Other")
    var selectedGender by remember { mutableStateOf("Male") }
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {

            Text(
                text = "👤 Personal Information",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            PatientInput("Patient Name", name) { name = it }

            PatientInput(
                label = "Age",
                value = age,
                keyboardType = KeyboardType.Number
            ) {
                if (it.length <= 3 && it.all { c -> c.isDigit() }) age = it
            }

            Spacer(modifier = Modifier.height(12.dp))

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                OutlinedTextField(
                    value = selectedGender,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Gender") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    genders.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(item) },
                            onClick = {
                                selectedGender = item
                                expanded = false
                            }
                        )
                    }
                }
            }

            PatientInput("Village", village) { village = it }

            PatientInput(
                label = "Mobile Number",
                value = mobile,
                keyboardType = KeyboardType.Phone
            ) {
                if (it.length <= 10 && it.all { c -> c.isDigit() }) mobile = it
            }
        }
    }
}