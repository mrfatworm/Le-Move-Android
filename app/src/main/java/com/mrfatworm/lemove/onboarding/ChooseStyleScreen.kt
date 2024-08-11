/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove.onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrfatworm.lemove.R
import com.mrfatworm.lemove.onboarding.data.ChooseStyleState
import com.mrfatworm.lemove.onboarding.data.StyleItemState
import com.mrfatworm.lemove.onboarding.data.stubChooseStyleState
import com.mrfatworm.lemove.ui.component.PrimaryButton
import com.mrfatworm.lemove.ui.theme.LeMoveTheme
import com.mrfatworm.lemove.ui.theme.LmColor
import com.mrfatworm.lemove.ui.theme.LmTypography
import com.mrfatworm.lemove.ui.theme.Radius
import com.mrfatworm.lemove.ui.theme.Spacing

@Composable
fun ChooseStyleScreen(
    modifier: Modifier = Modifier,
    uiState: ChooseStyleState = stubChooseStyleState,
    onNextClick: () -> Unit = {}
) {
    var selectedStyle by remember { mutableStateOf(0) }
    Box(
        modifier = modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .background(color = LmColor.surface)
                .padding(horizontal = Spacing.S24),
            columns = GridCells.Adaptive(140.dp),
            horizontalArrangement = Arrangement.spacedBy(Spacing.S32),
            verticalArrangement = Arrangement.spacedBy(Spacing.S32)
        ) {
            item(span = { GridItemSpan(this.maxCurrentLineSpan) }) { ChooseStyleHeader() }
            items(uiState.styleList.size) { index ->
                StyleItem(uiState.styleList[index], index == selectedStyle, onClick = {
                    selectedStyle = index
                })
            }
            repeat(2) {
                item {
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(Spacing.S64)
                    )
                }

            }
        }
        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Spacing.S16),
            text = stringResource(id = R.string.continue_str),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp)
        )
    }
}

@Composable
fun ChooseStyleHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = Spacing.S32),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Spacing.S32)
    ) {
        Text(
            text = stringResource(id = R.string.chose_notification_title),
            style = LmTypography.Headline2,
            color = LmColor.primary
        )
        Text(
            text = stringResource(id = R.string.chose_notification_desc),
            style = LmTypography.Caption,
            color = LmColor.textSecondary
        )
    }
}

@Composable
fun StyleItem(uiState: StyleItemState, isSelected: Boolean, onClick: () -> Unit = {}) {
    Card(modifier = Modifier.clickable { onClick() },
        shape = RoundedCornerShape(Radius.R24),
        border = if (isSelected) BorderStroke(width = 4.dp, color = LmColor.primary) else null) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.8f),
                painter = painterResource(id = uiState.imageId),
                contentDescription = ""
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .padding(if (isSelected) 4.dp else 0.dp)
                    .background(
                        brush = if (isSelected) Brush.verticalGradient(
                            listOf(Color(0x80000000), Color(0x80000000))
                        ) else Brush.verticalGradient(
                            listOf(Color(0x00000000), Color(0x80000000))
                        )
                    )
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (uiState.isPopular && !isSelected) {
                    Text(
                        modifier = Modifier
                            .background(
                                color = LmColor.primary, shape = RoundedCornerShape(Radius.R4)
                            )
                            .padding(horizontal = Spacing.S8, vertical = Spacing.S2),
                        text = stringResource(id = R.string.popular),
                        style = LmTypography.OverLine,
                        color = LmColor.onPrimary
                    )
                }
                Text(
                    text = stringResource(id = uiState.titleId),
                    style = LmTypography.Headline1,
                    color = LmColor.textPrimaryOnDark
                )
                if (isSelected) {
                    Text(
                        modifier = Modifier.padding(horizontal = Spacing.S8),
                        text = stringResource(id = uiState.descriptionId),
                        style = LmTypography.Caption,
                        color = LmColor.textPrimaryOnDark
                    )
                }
            }
        }
    }

}


@Preview
@Composable
fun ChooseStyleScreenPreview() {
    LeMoveTheme {
        ChooseStyleScreen()
    }
}