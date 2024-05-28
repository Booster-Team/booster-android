package com.booster.booster.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.booster.booster.ui.theme.BoosterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BoosterTheme {
            }
        }
    }
}

@Composable
fun MyApp() {

}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    BoosterTheme {
        MyApp()
    }
}