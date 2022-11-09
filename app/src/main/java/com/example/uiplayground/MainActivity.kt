package com.example.uiplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.uiplayground.presentation.FitnessTracker
import com.example.uiplayground.presentation.MindfullnessApp.AllTime
import com.example.uiplayground.presentation.MindfullnessApp.Statistics
import com.example.uiplayground.ui.theme.UiPlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UiPlaygroundTheme {
                AllTime()
            }
        }
    }
}