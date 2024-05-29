package com.booster.booster.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/*
* Primary : brand primary
On primary : label on brand
Primary container : brand primary light
On Primary container : label accent
* */

private val DarkColorScheme = darkColorScheme(
    primary = DarkBrandPrimary,
    onPrimary = DarkLabelPrimary,
    primaryContainer = DarkBrandPrimaryLight,
    onPrimaryContainer = DarkLabelAccent,
    error = DarkFeedbackError
)

private val LightColorScheme = lightColorScheme(
    primary = LightBrandPrimary,
    onPrimary = LightLabelPrimary,
    primaryContainer = LightBrandPrimaryLight,
    onPrimaryContainer = LightLabelAccent,
    error = LightFeedbackError
)

@Composable
fun BoosterTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Transparent.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}