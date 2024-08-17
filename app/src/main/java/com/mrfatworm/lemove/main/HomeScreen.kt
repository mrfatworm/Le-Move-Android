/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrfatworm.lemove.R
import com.mrfatworm.lemove.main.model.HomeState
import com.mrfatworm.lemove.main.model.sampleHomeState
import com.mrfatworm.lemove.ui.component.Avatar
import com.mrfatworm.lemove.ui.theme.LeMoveTheme
import com.mrfatworm.lemove.ui.theme.LmColor
import com.mrfatworm.lemove.ui.theme.LmTypography
import com.mrfatworm.lemove.ui.theme.Spacing

@Composable
fun HomeScreen(uiState: HomeState = sampleHomeState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = Spacing.S16, end = Spacing.S16, bottom = Spacing.S24),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Spacing.S16),
            horizontalArrangement = Arrangement.spacedBy(Spacing.S8)
        ) {
            Column(
                modifier = Modifier.weight(3f),
                verticalArrangement = Arrangement.spacedBy(Spacing.S8)
            ) {
                HomeImage(
                    modifier = Modifier.aspectRatio(200f / 212f),
                    imageId = R.drawable.img_home_01,
                    textId = R.string.home_img_text_01
                )
                HomeImage(
                    modifier = Modifier.aspectRatio(200f / 80f),
                    imageId = R.drawable.img_home_02,
                    textId = R.string.home_img_text_02
                )
            }
            Column(
                modifier = Modifier.weight(2f),
                verticalArrangement = Arrangement.spacedBy(Spacing.S8)
            ) {
                HomeImage(
                    modifier = Modifier.aspectRatio(135f / 146f),
                    imageId = R.drawable.img_home_03,
                    textId = R.string.home_img_text_03
                )
                HomeImage(
                    modifier = Modifier.aspectRatio(135f / 146f),
                    imageId = R.drawable.img_home_04,
                    textId = R.string.home_img_text_04
                )
            }
        }
        Text(
            modifier = Modifier.padding(top = Spacing.S16),
            text = stringResource(id = R.string.home_title_02),
            style = LmTypography.Headline2
        )
        LazyRow(modifier = Modifier.padding(top = Spacing.S16)){
            items(uiState.friends) { friend ->
                Avatar(imgId = friend.imgId, text = friend.name, enable = friend.enable)
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
    }
}

@Preview
@Composable
fun HomeImage(
    modifier: Modifier = Modifier,
    imageId: Int = R.drawable.img_home_01,
    textId: Int = R.string.home_img_text_01
) {
    Box(modifier = Modifier.clip(RoundedCornerShape(Spacing.S16))) {
        Image(modifier = modifier, painter = painterResource(id = imageId), contentDescription = "")
        Text(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(horizontal = Spacing.S16, vertical = Spacing.S8),
            text = stringResource(id = textId),
            style = LmTypography.Subtitle1,
            color = LmColor.textPrimaryOnDark
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    LeMoveTheme {
        Surface(color = LmColor.surface) {
            HomeScreen()
        }
    }
}