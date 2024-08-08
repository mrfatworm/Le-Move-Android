package com.mrfatworm.lemove.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.mrfatworm.lemove.R
import kotlinx.coroutines.delay

@Preview
@Composable
fun SplashScreen(gotoMainScreen: () -> Unit = {}) {
    LaunchedEffect(true) {
        delay(1000)
        gotoMainScreen()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = splashBackground),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = R.drawable.logo_outline), contentDescription = "Logo")
    }
}

val splashBackground = Brush.linearGradient(
    start = Offset(0f, 0f),
    end = Offset(1000f, 1000f),
    colors = listOf(Color(0xFF7DE5B6), Color(0xFF50BBD0))
)