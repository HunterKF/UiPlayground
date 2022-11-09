package com.example.uiplayground.presentation.MindfullnessApp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.uiplayground.R
import com.example.uiplayground.presentation.linearGradient
import com.example.uiplayground.ui.theme.*

@Composable
fun AllTime() {
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
            Text(
                text = "All time",
                textAlign = TextAlign.Left
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SessionCard(
                    mainText = "23 sessions",
                    subtext = "of meditations",
                    icon = R.drawable.lotus,
                    color1 = Purple,
                    modifier = Modifier.weight(1f),
                    angle = 120f,
                    colors = listOf(
                        IconPurple,
                        IconTeal
                    )
                )
                SessionCard(
                    mainText = "23 sessions",
                    subtext = "of meditations",
                    icon = R.drawable.button,
                    color1 = Green,
                    modifier = Modifier.weight(1f),
                    angle = 50f,
                    colors = listOf(
                        IconTeal,
                        IconPurple
                    ),
                    offset = Offset(50f, 0f)
                )
            }
            Text(
                text = "This week"
            )
            Chart()

        }
    }
}

@Composable
fun SessionCard(
    mainText: String,
    subtext: String,
    icon: Int = R.drawable.strength,
    modifier: Modifier = Modifier,
    color1: Color = Color.Green,
    color2: Color = Color.Black,
    angle: Float = 0f,
    offset: Offset = Offset(60f, 130f),
    colors: List<Color>,
) {
    Box(
        modifier = modifier
            .padding(20.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        val brushGradient = Brush.radialGradient(

            colors = colors,
            center = offset
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.linearGradient(
                        0.1f to color1.copy(0.7f),
                        0.9f to color2.copy(1f),
                        angleInDegrees = angle,
                    )
                )
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center) {
                    Icon(painterResource(id = icon), contentDescription = null,
                        modifier = Modifier
                            .graphicsLayer(alpha = 0.99f)
                            .drawWithCache {
                                onDrawWithContent {
                                    drawContent()
                                    drawRect(brushGradient, blendMode = BlendMode.SrcAtop)
                                }
                            })
                }
                Text(
                    text = mainText
                )
                Text(
                    text = subtext
                )
            }
        }

    }

}


@Composable
fun Chart(
) {
    val days = listOf(
        "Sun",
        "Mon",
        "Tue",
        "Wed",
        "Thu",
        "Fri",
        "Sat",
    )
    val time = listOf(
        "60 m",
        "45 m",
        "30 m",
        "15 m",
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White
                .copy(0.9f))
    ) {

        Column(Modifier
            .fillMaxHeight()
            .weight(0.1f), verticalArrangement = Arrangement.SpaceBetween) {
            time.forEach {
                Text(text = it)
            }
            Text("")
            Text("")
        }


        Box(Modifier
            .weight(0.99f)
            .fillMaxSize()) {
            Column(
                Modifier
                    .fillMaxHeight(0.75f)
                    .offset(y = 14.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                time.forEach {
                    Divider()
                }
                Divider()
            }
            Box(Modifier
                .fillMaxWidth()
                .height(240.dp)
                .border(2.dp, Color.Red)) {
                ChartBar(height = 0.45f)
            }
            Spacer(Modifier.height(10.dp))
            Row(Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(top = 12.dp, bottom = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                days.forEach {
                    Text(it)
                }
            }

        }
    }
}

@Composable
fun ChartBar(
    width: Dp = 8.dp,
    color: Color = NeonTeal,
    height: Float = 0f
) {
    val spacerHeight = 1f - height
    Spacer(Modifier.fillMaxHeight(spacerHeight))
    Box(
        modifier = Modifier
            .width(width)
            .fillMaxHeight(height)
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        color,
                        Color.Transparent
                    )
                )
            )
    )
}


@Preview()
@Composable
fun Preview2() {
    Box(Modifier.height(300.dp)){
        Chart()
    }

}



