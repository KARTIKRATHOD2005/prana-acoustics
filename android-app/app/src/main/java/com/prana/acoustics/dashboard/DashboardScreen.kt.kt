package com.prana.acoustics.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DashboardScreen(
    onRegisterPatient: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFFE3F2FD), Color.White)
                )
            )
            .padding(20.dp)
    ) {
        Column {
            Text(
                "Good Morning 👋",
                fontSize = 18.sp,
                color = Color(0xFF607D8B)
            )

            Text(
                "ASHA Dashboard",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0D47A1)
            )

            Spacer(modifier = Modifier.height(24.dp))

            DashboardCard(
                icon = "👤",
                title = "Register Patient",
                subtitle = "Add a new patient profile",
                onClick = onRegisterPatient
            )

            DashboardCard("🩺", "Start Screening", "Symptoms, vitals, cough and scans")
            DashboardCard("📋", "Patient Records", "View saved patient history")
            DashboardCard("☁️", "Offline Sync", "Upload pending village data")
            DashboardCard("⚙️", "Settings", "Language, profile and permissions")
        }
    }
}

@Composable
fun DashboardCard(
    icon: String,
    title: String,
    subtitle: String,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 14.dp),
        shape = RoundedCornerShape(22.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(18.dp)
        ) {
            Text(icon, fontSize = 32.sp)

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    subtitle,
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }
        }
    }
}