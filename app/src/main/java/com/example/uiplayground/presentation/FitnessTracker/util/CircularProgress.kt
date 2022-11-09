package com.example.uiplayground.presentation.FitnessTracker.util

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uiplayground.ui.theme.PrimaryOrange

@Composable
fun CircularProgress(
    tracker: Tracker,
) {
    val width = 5.dp
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.padding(bottom = 4.dp)
        ) {
            CircularProgressIndicator(
                progress = 0.55f,
                color = PrimaryOrange,
                strokeWidth = width,
                modifier = Modifier.then(Modifier.size(50.dp))
            )
            CircularProgressIndicator(
                progress = 1f,
                color = PrimaryOrange.copy(0.3f),
                strokeWidth = width,
                modifier = Modifier.then(Modifier.size(50.dp))
            )
            Icon(
                painter = painterResource(id = tracker.icon),
                null,
                modifier = Modifier.align(Alignment.Center).scale(2f)
            )
        }
        Text(
            text = tracker.value,
            style = MaterialTheme.typography.body1
        )
        Text(
            text = tracker.type,
            style = MaterialTheme.typography.subtitle1
        )
    }
}