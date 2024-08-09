package com.mrfatworm.lemove.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrfatworm.lemove.R
import com.mrfatworm.lemove.onboarding.data.InfoPager
import com.mrfatworm.lemove.onboarding.data.OnBoardIntroState
import com.mrfatworm.lemove.onboarding.data.stubOnboardIntroState
import com.mrfatworm.lemove.ui.theme.LmColor
import com.mrfatworm.lemove.ui.theme.Spacing
import com.mrfatworm.lemove.ui.theme.Typography
import com.mrfatworm.lemove.ui.theme.blue500
import com.mrfatworm.lemove.ui.theme.neutral200
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
                .background(color = LmColor().surface)
                .padding(Spacing().l),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            HorizontalPager(state = pagerState, pageSpacing = Spacing().l) { pagerState ->
                OnBoardingIntroPagerItem(uiState.infoPagers[pagerState])
            }

            Column(verticalArrangement = Arrangement.spacedBy(Spacing().s)) {
                Row(
                    Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 8.dp), horizontalArrangement = Arrangement.Center
                ) {
                    repeat(pagerState.pageCount) { iteration ->
                        val color =
                            if (pagerState.currentPage == iteration) LmColor().primary else neutral200
                        val size = if (pagerState.currentPage == iteration) 20.dp else 6.dp
                        Box(
                            modifier = Modifier
                                .padding(Spacing().xss)
                                .clip(RoundedCornerShape(6.dp))
                                .background(color = color)
                                .size(height = 6.dp, width = size)
                        )
                    }
                }
                Button(modifier = Modifier.fillMaxWidth(), onClick = {
                    if (pagerState.currentPage < pagerState.pageCount) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                }) {
                    Text(
                        text = stringResource(id = R.string.continue_str),
                        style = Typography().button
                    )
                }
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
                        color = LmColor().primary
                    )
                }
            }
        }
    }
}

@Composable
fun OnBoardingIntroPagerItem(infoPager: InfoPager) {
    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            painter = painterResource(id = infoPager.imageId),
            contentDescription = ""
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            text = stringResource(id = infoPager.titleId),
            textAlign = TextAlign.Center,
            color = LmColor().primary,
            style = Typography().headline2
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            text = stringResource(id = infoPager.descriptionId),
            textAlign = TextAlign.Center,
            color = LmColor().textPrimary,
            style = Typography().caption
        )
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