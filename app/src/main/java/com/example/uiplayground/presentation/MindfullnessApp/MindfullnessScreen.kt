package com.example.uiplayground.presentation.MindfullnessApp

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIos
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uiplayground.ui.theme.*

@Composable
fun Statistics() {

    Surface(
        contentColor = Color.White
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Black700)
        ) {
            Row(Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Outlined.ArrowBackIos,
                        null
                    )
                }
                Text(
                    text = "Statistics"
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Outlined.Settings,
                        null
                    )
                }
            }
            Spacer(Modifier.height(30.dp))
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Activity Types",
                    style = MaterialTheme.typography.h6
                )
                Spacer(Modifier.height(30.dp))
                StatisticCard(modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(20.dp)))
            }

        }
    }
}

@Composable
fun StatisticCard(modifier: Modifier = Modifier) {
    val statistic = listOf(
        StatisticObject(
            text = "Meditation",
            time = 48,
            colorOne = NeonPink,
            colorTwo = NeonPurple,
            percentage = 61
        ),
        StatisticObject(
            text = "Breathwork",
            time = 0,
            colorOne = NeonPeach,
            colorTwo = NeonYellow,
            percentage = 24
        ),
        StatisticObject(
            text = "Yoga",
            time = 0,
            colorOne = NeonTeal,
            colorTwo = NeonDarkTeal,
            percentage = 15
        ),
    )

    Card(
        modifier = modifier,
        backgroundColor = Black500
    ) {
        Column(modifier = Modifier
            .fillMaxSize(1f)
            .padding(16.dp)) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center) {
                CircularProgressBar(percentage = 0.55f,
                    number = 3130,
                    color = NeonPurple,
                    startAngle = -90f)
                CircularProgressBar(percentage = 0.17f,
                    number = 3130,
                    color = NeonPeach,
                    startAngle = 125f)
                CircularProgressBar(percentage = 0.13f,
                    number = 0,
                    color = NeonTeal,
                    startAngle = 205f)
            }
            Column(
                modifier = Modifier.weight(0.3f)
            ) {
                statistic.forEach {
                    StatisticRow(statisticObject = it)
                }
            }
        }
    }
}

@Composable
fun StatisticRow(statisticObject: StatisticObject) {
    Row(Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
        val boxSize = with(LocalDensity.current) { 20.dp.toPx() }
        Box(
            modifier = Modifier
                .size(20.dp)
                .clip(CircleShape)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(statisticObject.colorOne, statisticObject.colorTwo),
                        start = Offset(0f, 0f), // top left corner
                        end = Offset(boxSize, boxSize) // bottom right corner
                    )
                )
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = statisticObject.text,
            textAlign = TextAlign.Left,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "${statisticObject.percentage}%"
        )

    }
}

@Composable
fun CircularProgressBar(
    percentage: Float,
    number: Int = 0,
    startAngle: Float = -90f,
    fontSize: TextUnit = 28.sp,
    radius: Dp = 120.dp,
    color: Color = Color.Green,
    strokeWidth: Dp = 18.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0,
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }

    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius * 2f)
    ) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = color,
                startAngle = startAngle,
                sweepAngle = 360 * curPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview() {
    Statistics()
}