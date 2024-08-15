/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrfatworm.lemove.R
import com.mrfatworm.lemove.ui.navigation.BottomScreens
import com.mrfatworm.lemove.ui.navigation.LeMoveNavActions
import com.mrfatworm.lemove.ui.theme.LmColor
import com.mrfatworm.lemove.ui.theme.Spacing

@Composable
fun LeMoveBottomNavigation(
    selectedDestination: String, navActions: LeMoveNavActions?
) {
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Spacing.S12, vertical = Spacing.S16)
            .background(color = LmColor.surface, shape = CircleShape)
    ) {
        BottomScreens.forEach { screen ->
            val selected = selectedDestination == screen.route
            NavigationBarItem(selected = selected, onClick = {
                if (!selected) {
                    navActions?.navigationToTop(screen)
                }
            }, icon = {
                Icon(
                    painter = painterResource(id = screen.icon),
                    contentDescription = stringResource(
                        id = screen.textId
                    )
                )
            }, label = {
                Text(text = stringResource(id = screen.textId))
            })
        }
    }
}

@Composable
fun NavItem(modifier: Modifier = Modifier, iconId: Int, @StringRes textId: Int) {
    Column(
        modifier = modifier
            .clip(CircleShape)
            .shadow(elevation = 8.dp, shape = CircleShape)
            .padding(horizontal = Spacing.S32, vertical = Spacing.S8),
        verticalArrangement = Arrangement.spacedBy(Spacing.S4)
    ) {
        Icon(
            painter = painterResource(id = iconId), contentDescription = stringResource(id = textId)
        )
        Text(text = stringResource(id = textId))

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