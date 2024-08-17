/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mrfatworm.lemove.R
import com.mrfatworm.lemove.onboarding.model.InfoPager
import com.mrfatworm.lemove.onboarding.model.sampleOnboardIntro2State
import com.mrfatworm.lemove.ui.component.OnBoardingIntroPagerItem
import com.mrfatworm.lemove.ui.component.PrimaryButton
import com.mrfatworm.lemove.ui.component.SecondaryButton
import com.mrfatworm.lemove.ui.theme.LeMoveTheme
import com.mrfatworm.lemove.ui.theme.LmColor
import com.mrfatworm.lemove.ui.theme.Spacing

@Composable
fun OnboardingIntro2Screen(
    modifier: Modifier = Modifier,
    uiState: InfoPager = sampleOnboardIntro2State,
    onNextClick: () -> Unit = {},
    onStartClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = LmColor.surface)
            .padding(Spacing.S24),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        OnBoardingIntroPagerItem(uiState)

        Column(verticalArrangement = Arrangement.spacedBy(Spacing.S12)) {
            SecondaryButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.later),
                onClick = onNextClick
            )
            PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.let_start),
                onClick = onStartClick
            )
        }
    }
}


@Preview
@Composable
fun OnboardingIntro2ScreenPreview() {
    LeMoveTheme {
        Surface {
            OnboardingIntro2Screen()
        }
    }
}