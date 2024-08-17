/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrfatworm.lemove.R
import com.mrfatworm.lemove.ui.navigation.BottomScreens
import com.mrfatworm.lemove.ui.navigation.LeMoveNavActions
import com.mrfatworm.lemove.ui.theme.LmColor
import com.mrfatworm.lemove.ui.theme.LmTypography
import com.mrfatworm.lemove.ui.theme.Spacing

@Composable
fun LeMoveBottomNavigation(
    modifier: Modifier = Modifier, selectedDestination: String, navActions: LeMoveNavActions?
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = Spacing.S12, end = Spacing.S12, bottom = Spacing.S24)
            .shadow(elevation = 2.dp, shape = CircleShape)
            .background(color = LmColor.surface, shape = CircleShape)
            .padding(horizontal = Spacing.S8, vertical = Spacing.S8)
    ) {
        BottomScreens.forEach { screen ->
            val selected = selectedDestination == screen.route
            NavItem(modifier = Modifier.weight(1f),
                selected = selected,
                iconId = screen.icon,
                textId = screen.textId,
                onClick = {
                    if (!selected) {
                        navActions?.navigationToTop(screen)
                    }
                })
        }
    }
}

@Composable
fun NavItem(
    modifier: Modifier = Modifier,
    iconId: Int,
    @StringRes textId: Int,
    selected: Boolean = false,
    onClick: () -> Unit = {}
) {
    Column(modifier = modifier
        .clickable(
            interactionSource = remember { MutableInteractionSource() }, indication = null
        ) { onClick() }
        .shadow(elevation = if (selected) 2.dp else 0.dp, shape = CircleShape)
        .background(LmColor.surface)
        .padding(horizontal = Spacing.S32, vertical = Spacing.S8),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Spacing.S4)) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = stringResource(id = textId),
            tint = if (selected) LmColor.primary else LmColor.textSecondary
        )
        Text(
            text = stringResource(id = textId),
            style = LmTypography.Caption,
            color = if (selected) LmColor.primary else LmColor.textSecondary
        )

    }
}

@Preview
@Composable
fun LeMoveBottomNavigationPreview() {
    LeMoveBottomNavigation(selectedDestination = "", navActions = null)
}

@Preview
@Composable
fun NavItemPreview() {
    Surface(color = LmColor.surface) {
        NavItem(iconId = R.drawable.ic_home, textId = R.string.home)
    }
}