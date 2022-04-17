package com.breens.jetpackcomposeecommerceapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.breens.jetpackcomposeecommerceapp.R


val elmessri = FontFamily(
    listOf(
        Font(R.font.elmessiri_regular, FontWeight.Normal),
        Font(R.font.elmessiri_medium, FontWeight.Medium),
        Font(R.font.elmessiri_semibold, FontWeight.SemiBold),
        Font(R.font.elmessiri_bold, FontWeight.Bold),
    )
)

val Typography = Typography(
    body1 = TextStyle(
        color = ColorBlack,
        fontFamily = elmessri,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    body2 = TextStyle(
        color = ColorGrey,
        fontFamily = elmessri,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        color = ColorBlack,
        fontFamily = elmessri,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    h2 = TextStyle(
        color = ColorGrey,
        fontFamily = elmessri,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        color = ColorBlack,
        fontFamily = elmessri,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    h4 = TextStyle(
        color = ColorGrey,
        fontFamily = elmessri,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
)