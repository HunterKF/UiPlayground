package com.example.uiplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uiplayground.presentation.FitnessTracker
import com.example.uiplayground.presentation.MindfullnessApp.AllTime
import com.example.uiplayground.presentation.MindfullnessApp.Statistics
import com.example.uiplayground.presentation.ShimmerListItem
import com.example.uiplayground.presentation.autoresizetext.AutoResizedText
import com.example.uiplayground.ui.theme.UiPlaygroundTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UiPlaygroundTheme {
                var isLoading by remember {
                    mutableStateOf(true)
                }
                LaunchedEffect(key1 = true, block = {
                    delay(2000)
                    isLoading = false
                })
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .width(200.dp)
                            .background(Color.LightGray)
                    ) {
                        AutoResizedText(
                            text = "Plastic world",
                            style = MaterialTheme.typography.h1
                        )
                    }
                }

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(20) {
                        ShimmerListItem(
                            isLoading = isLoading,
                            contentAfterLoading = {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.LightGray)
                                ) {
                                    AutoResizedText(
                                        text = "Hello world",
                                        style = MaterialTheme.typography.h1
                                    )
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}