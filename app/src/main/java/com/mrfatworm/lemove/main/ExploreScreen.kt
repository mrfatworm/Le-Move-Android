/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mrfatworm.lemove.R
import com.mrfatworm.lemove.ui.theme.LeMoveTheme
import com.mrfatworm.lemove.ui.theme.LmColor
import com.mrfatworm.lemove.ui.theme.LmTypography
import com.mrfatworm.lemove.ui.theme.Spacing

@Composable
fun ExploreScreen(modifier: Modifier = Modifier, onNextClick: () -> Unit = {}) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = Spacing.S24, end = Spacing.S24, bottom = Spacing.S24),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = Spacing.S48),
                verticalArrangement = Arrangement.spacedBy(Spacing.S8),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.explore),
                    style = LmTypography.Headline2,
                    color = LmColor.textPrimary
                )

            }
        }
}

@Preview
@Composable
fun ExploreScreenPreview() {
    LeMoveTheme {
        Surface(color = LmColor.surface) {
            ExploreScreen()
        }
    }
}