package com.booster.booster.ui.main

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.booster.booster.repository.GoogleLoginRepository
import com.booster.booster.ui.screen.LoginScreen
import com.booster.booster.ui.screen.bottom.profile.SettingScreen
import com.booster.booster.ui.screen.bottom.profile.ProfileScreen
import com.booster.booster.ui.theme.BoosterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var googleLoginRepository: GoogleLoginRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        googleLoginRepository = GoogleLoginRepository(this)

        setContent {
            BoosterTheme {
                MyApp(googleLoginRepository)
            }
        }
    }
}

@Composable
fun MyApp(googleLoginRepository: GoogleLoginRepository) {
    val navController = rememberNavController()

    val startDestination = if (googleLoginRepository.hasAccount()) "main" else "login"

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("login") { LoginScreen(navController = navController)}
        composable("main") { MainScreen(navController = navController) }
        composable("profile") { ProfileScreen(navController = navController) }
        composable("settings"){  SettingScreen(navController = navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    BoosterTheme {
        MyApp(GoogleLoginRepository(LocalContext.current as Activity))
    }
}