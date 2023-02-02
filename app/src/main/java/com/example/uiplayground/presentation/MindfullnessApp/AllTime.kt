package com.example.uiplayground.presentation.MindfullnessApp

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
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
            Card(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(15.dp)),
                backgroundColor = Black500
            ) {
                Column(
                    modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)
                ) {
                    Row(Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            text = "Total time:",
                            style = MaterialTheme.typography.h5
                        )
                        Text(
                            text = "3h 34min",
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.h5
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Box(
                        Modifier.height(300.dp)
                    ) {

                        Chart()
                    }
                }

            }


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
    val stats = listOf(
        0.2f,
        0.3f,
        0.27f,
        0.21f,
        0.65f,
        1f,
        0.14f
    )


    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Column(Modifier
            .fillMaxHeight()
            .weight(0.15f), verticalArrangement = Arrangement.SpaceBetween) {
            time.forEach {
                Text(
                    text = it,
                    color = Color.LightGray.copy(0.5f)
                )
            }
            Text("")
            Text("")
        }


        Box(Modifier
            .weight(0.9f)
            .fillMaxSize()) {
            Column(
                Modifier
                    .fillMaxHeight(0.75f)
                    .offset(y = 14.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                time.forEach { _ ->
                    Divider(Modifier.height(2.dp),
                        color = Color.LightGray.copy(0.5f))
                }
                Divider(Modifier.height(2.dp),
                    color = Color.LightGray.copy(0.5f))
            }
            var size by remember { mutableStateOf(IntSize.Zero) }
            Box(Modifier
                .fillMaxWidth()
                .onSizeChanged {
                    size = it
                }
                .height(240.dp)) {
                Row(Modifier
                    .fillMaxSize()
                    .padding(horizontal = 0.dp),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    val columnWidth = (size.width.dp / 7)
                    stats.forEach {
                        ChartBar(height = it, size = size, columnWidth = columnWidth)
                    }
                }
            }
            Spacer(Modifier.height(10.dp))
            Row(Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(top = 12.dp, bottom = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                days.forEach {
                    Box(Modifier.border(2.dp, Color.Red)) {
                        Text(it,
                            textAlign = TextAlign.Center,

                            color = Color.LightGray.copy(0.5f))
                    }
                }
            }

        }
    }
}

@Composable
fun ChartBar(
    width: Dp = 8.dp,
    color: Color = NeonTeal,
    height: Float = 0.5f,
    columnWidth: Dp,
    size: IntSize,
) {
    val context = LocalContext.current
    val spacerHeight = 1f - height
    Column(Modifier
        .fillMaxHeight()
        .width(40.dp)
        .border(2.dp, Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally) {
        if (spacerHeight in 0.1f..1f) {
            Box(Modifier
                .width(width)
                .weight(spacerHeight)
                .fillMaxHeight()
            )
//                .border(2.dp, Color.Green))
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(100))
                .weight(height)
                .width(width)
                .fillMaxHeight(0.5f)
                .background(
                    Brush.linearGradient(
                        0.1f to color,
                        0.4f to color,
                        0.6f to color.copy(0.5f),
                        0.8f to Color.Transparent,
                        angleInDegrees = 270f
                    )
                )
//                .border(2.dp, Color.Blue)
                .clickable {
                    Toast
                        .makeText(context,
                            "Value of spacerHeight: ${spacerHeight}",
                            Toast.LENGTH_SHORT)
                        .show()
                }
        )
    }

}


@Preview()
@Composable
fun Preview2() {
    Box(Modifier.height(300.dp)) {
        Chart()
    }

}



