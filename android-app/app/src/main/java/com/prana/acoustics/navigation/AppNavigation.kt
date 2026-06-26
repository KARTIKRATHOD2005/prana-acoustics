package com.prana.acoustics.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prana.acoustics.dashboard.DashboardScreen
import com.prana.acoustics.login.LoginScreen
import com.prana.acoustics.login.OtpScreen
import com.prana.acoustics.patient.ui.PatientRegistrationScreen
import com.prana.acoustics.splash.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(
                onSplashFinished = {
                    navController.navigate("login") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )
        }

        composable("login") {
            LoginScreen(
                onSendOtp = {
                    navController.navigate("otp")
                }
            )
        }

        composable("otp") {
            OtpScreen(
                onVerifySuccess = {
                    navController.navigate("dashboard") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

        composable("dashboard") {
            DashboardScreen(
                onRegisterPatient = {
                    navController.navigate("patient_registration")
                }
            )
        }

        composable("patient_registration") {
            PatientRegistrationScreen()
        }
    }
}