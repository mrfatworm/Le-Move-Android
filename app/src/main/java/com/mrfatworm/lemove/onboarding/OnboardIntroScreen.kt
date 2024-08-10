/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrfatworm.lemove.R
import com.mrfatworm.lemove.onboarding.data.OnBoardIntroState
import com.mrfatworm.lemove.onboarding.data.stubOnboardIntroState
import com.mrfatworm.lemove.ui.component.OnBoardingIntroPagerItem
import com.mrfatworm.lemove.ui.component.PagerIndicator
import com.mrfatworm.lemove.ui.component.PrimaryButton
import com.mrfatworm.lemove.ui.theme.LeMoveTheme
import com.mrfatworm.lemove.ui.theme.LmColor
import com.mrfatworm.lemove.ui.theme.LmTypography
import com.mrfatworm.lemove.ui.theme.Spacing
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingIntroScreen(
    modifier: Modifier = Modifier,
    uiState: OnBoardIntroState = stubOnboardIntroState,
    pagerState: PagerState = rememberPagerState(pageCount = { 1 }),
    onNextClick: () -> Unit = {}
) {
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = LmColor.surface)
            .padding(Spacing.S24),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        HorizontalPager(
            state = pagerState, pageSpacing = Spacing.S24, verticalAlignment = Alignment.Top
        ) { pagerState ->
            OnBoardingIntroPagerItem(uiState.infoPagers[pagerState])
        }

        Column(verticalArrangement = Arrangement.spacedBy(Spacing.S12)) {
            PagerIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                pageCount = pagerState.pageCount,
                currentPage = pagerState.currentPage
            )
            PrimaryButton(modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.continue_str),
                onClick = {
                    if (pagerState.currentPage < pagerState.pageCount - 1) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    } else {
                        onNextClick()
                    }
                })
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.is_exist_user), style = LmTypography.Caption
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = stringResource(id = R.string.sign_in),
                    style = LmTypography.Caption,
                    color = LmColor.primary
                )
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun OnboardingIntroScreenPreview() {
    LeMoveTheme {
        OnboardingIntroScreen()
    }
}