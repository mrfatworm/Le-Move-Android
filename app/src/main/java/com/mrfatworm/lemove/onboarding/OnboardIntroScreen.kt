package com.mrfatworm.lemove.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrfatworm.lemove.R
import com.mrfatworm.lemove.onboarding.data.OnBoardIntroState
import com.mrfatworm.lemove.onboarding.data.stubOnboardIntroState
import com.mrfatworm.lemove.ui.component.LmButton
import com.mrfatworm.lemove.ui.component.OnBoardingIntroPagerItem
import com.mrfatworm.lemove.ui.component.PagerIndicator
import com.mrfatworm.lemove.ui.theme.LmColor
import com.mrfatworm.lemove.ui.theme.Spacing
import com.mrfatworm.lemove.ui.theme.Typography
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun OnboardingIntroScreen(uiState: OnBoardIntroState = stubOnboardIntroState) {
    val pagerState = rememberPagerState(pageCount = { 3 })
    val coroutineScope = rememberCoroutineScope()
    Scaffold(topBar = {
        TopBar(showBackIcon = pagerState.currentPage != 0, onBackClick = {
            coroutineScope.launch {
                pagerState.animateScrollToPage(pagerState.currentPage - 1)
            }
        })
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = LmColor.surface)
                .padding(Spacing.L),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            HorizontalPager(
                state = pagerState, pageSpacing = Spacing.L, verticalAlignment = Alignment.Top
            ) { pagerState ->
                OnBoardingIntroPagerItem(uiState.infoPagers[pagerState])
            }

            Column(verticalArrangement = Arrangement.spacedBy(Spacing.S)) {
                PagerIndicator(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    pageCount = pagerState.pageCount,
                    currentPage = pagerState.currentPage
                )
                LmButton(modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.continue_str),
                    onClick = {
                        if (pagerState.currentPage < pagerState.pageCount) {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        }
                    })
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.is_exist_user),
                        style = Typography().caption
                    )
                    Text(
                        modifier = Modifier.padding(start = 4.dp),
                        text = stringResource(id = R.string.sign_in),
                        style = Typography().caption,
                        color = LmColor.primary
                    )
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(showBackIcon: Boolean = true, onBackClick: () -> Unit = {}) {
    CenterAlignedTopAppBar(title = {
        Image(
            painter = painterResource(id = R.drawable.logo), contentDescription = "Logo"
        )
    }, navigationIcon = {
        if (showBackIcon) {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_left),
                    contentDescription = "Back"
                )
            }
        }
    })
}