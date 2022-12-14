package com.example.uiplayground.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uiplayground.R

val Varela = FontFamily(
    Font(R.font.varela_round_regular, weight = FontWeight.Normal)
)
// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = Varela,
    body1 = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 14.sp
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Thin,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)