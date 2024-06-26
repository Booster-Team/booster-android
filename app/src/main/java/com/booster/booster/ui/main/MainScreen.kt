package com.booster.booster.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.booster.booster.ui.screen.BottomNavigationScreen

@Composable
fun  MainScreen(navController: NavController) {
    BottomNavigationScreen(navController = navController)
}