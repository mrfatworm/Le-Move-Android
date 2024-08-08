package com.mrfatworm.lemove.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrfatworm.lemove.R
import com.mrfatworm.lemove.ui.theme.LmColor
import com.mrfatworm.lemove.ui.theme.Spacing
import com.mrfatworm.lemove.ui.theme.Typography

@Preview
@Composable
fun OnboardingIntroScreen() {
    Scaffold(topBar = { TopBar() }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = LmColor().surface)
                .padding(Spacing().l),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                painter = painterResource(id = R.drawable.img_onboarding1),
                contentDescription = ""
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                text = "久坐族必備",
                textAlign = TextAlign.Center,
                color = LmColor().primary,
                style = Typography().headline2
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                text = "長期待在椅子上沒空運動？在椅子上就能做簡單的伸展運動！",
                textAlign = TextAlign.Center,
                color = LmColor().textPrimary,
                style = Typography().caption
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar() {
    CenterAlignedTopAppBar(title = {
        Image(
            painter = painterResource(id = R.drawable.logo), contentDescription = "Logo"
        )
    }, navigationIcon = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = "Back"
            )
        }
    })
}