package com.mrfatworm.lemove.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mrfatworm.lemove.R

val noToSansTc = FontFamily(
    Font(R.font.noto_sans_tc_regular, FontWeight.Normal),
    Font(R.font.noto_sans_tc_medium, FontWeight.Medium),
    Font(R.font.noto_sans_tc_bold, FontWeight.Bold)
)

data class Typography(
    val display: TextStyle = TextStyle(
        fontFamily = noToSansTc,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        lineHeight = 42.sp,
        letterSpacing = 0.sp
    ), val headline1: TextStyle = TextStyle(
        fontFamily = noToSansTc,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 35.sp,
        letterSpacing = 0.sp
    ), val headline2: TextStyle = TextStyle(
        fontFamily = noToSansTc,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ), val subtitle1: TextStyle = TextStyle(
        fontFamily = noToSansTc,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 29.sp,
        letterSpacing = 0.sp
    ), val subtitle2: TextStyle = TextStyle(
        fontFamily = noToSansTc,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ), val body1: TextStyle = TextStyle(
        fontFamily = noToSansTc,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 25.sp,
        letterSpacing = 0.sp
    ), val body2: TextStyle = TextStyle(
        fontFamily = noToSansTc,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 23.sp,
        letterSpacing = 0.sp
    ), val button: TextStyle = TextStyle(
        fontFamily = noToSansTc,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.sp
    ), val caption: TextStyle = TextStyle(
        fontFamily = noToSansTc,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    ), val overLine: TextStyle = TextStyle(
        fontFamily = noToSansTc,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    )
)