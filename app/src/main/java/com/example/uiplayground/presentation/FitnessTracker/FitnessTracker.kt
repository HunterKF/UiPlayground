package com.example.uiplayground.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.DoorBack
import androidx.compose.material.icons.rounded.KeyboardBackspace
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uiplayground.R
import com.example.uiplayground.presentation.FitnessTracker.util.CircularProgress
import com.example.uiplayground.presentation.FitnessTracker.util.Tracker
import com.example.uiplayground.ui.theme.PrimaryOrange
import com.example.uiplayground.ui.theme.SecondaryOrange


/*https://dribbble.com/shots/19771062-Fitness-tracking-Mobile-App-UI-Concept*/
@Composable
fun FitnessTracker() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(Modifier.background(PrimaryOrange)) {
            Box(Modifier
                .fillMaxWidth()
                .weight(0.1f)
                .padding(16.dp)) {
                IconButton(
                    modifier = Modifier.align(Alignment.CenterStart),
                    onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Rounded.ArrowBackIos,
                        null,
                        tint = Color.White
                    )
                }
                Text(
                    text = stringResource(R.string.my_progress),
                    style = MaterialTheme.typography.h6,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Column(Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .weight(0.4f)
                .background(Color.White)
                .padding(24.dp)
            ) {
                Row(
                    Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.average_calories_burned),
                        style = MaterialTheme.typography.h6,
                        letterSpacing = 0.1.sp
                    )
                    DropdownMenuItem(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .clip(RoundedCornerShape(15.dp))
                            .background(SecondaryOrange)
                    ) {
                        Text(
                            text = "May 2022",
                            style = MaterialTheme.typography.body1
                        )
                        Icon(
                            Icons.Rounded.ArrowDropDown,
                            null
                        )
                    }
                }

            }

            Column(
                modifier = Modifier
//                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .fillMaxWidth()
                    .weight(0.4f)
                    .background(Color.White)
            ) {
                Column(
                    Modifier
                        .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                        .background(SecondaryOrange)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Today",
                        style = MaterialTheme.typography.h6
                    )
                    Spacer(Modifier.height(8.dp))
                    Box() {
                        val width = 8.dp
                        val size = 130.dp
                        CircularProgressIndicator(
                            progress = 0.55f,
                            color = PrimaryOrange,
                            strokeWidth = width,
                            modifier = Modifier.then(Modifier.size(size))
                        )
                        CircularProgressIndicator(
                            progress = 1f,
                            color = PrimaryOrange.copy(0.3f),
                            strokeWidth = width,
                            modifier = Modifier.then(Modifier.size(size))
                        )
                        Column(
                            modifier = Modifier.align(Alignment.Center),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "243",
                                style = MaterialTheme.typography.h5
                            )
                            Text(
                                text = "calories",
                                style = MaterialTheme.typography.subtitle1
                            )
                        }
                    }
                    Spacer(Modifier.height(6.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        CircularProgress(tracker = Tracker.Steps)
                        CircularProgress(tracker = Tracker.Kilometers)
                        CircularProgress(tracker = Tracker.Time)
                    }
                }


            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview() {
    FitnessTracker()
}