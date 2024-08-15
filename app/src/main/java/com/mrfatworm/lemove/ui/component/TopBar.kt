/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mrfatworm.lemove.R
import com.mrfatworm.lemove.ui.theme.LmColor
import com.mrfatworm.lemove.ui.theme.LmTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LmTopBar(
    title: String? = null, onBackClick: () -> Unit = {}, actions: @Composable () -> Unit = {}
) {
    CenterAlignedTopAppBar(title = {
        title?.let {
            Text(text = title)
        }
    }, navigationIcon = {
        IconButton(onClick = { onBackClick() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = "Back"
            )
        }
    }, actions = {
        actions()
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    @StringRes titleId: Int? = null, onActionClick: () -> Unit = {}
) {
    TopAppBar(title = {
        titleId?.let {
            Text(
                text = stringResource(id = titleId),
                style = LmTypography.Headline2,
                color = LmColor.textPrimary
            )
        }
    }, actions = {
        IconButton(onClick = onActionClick) {
            Box {
                Icon(
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = "Notification"
                )
                Spacer(
                    modifier = Modifier
                        .size(6.dp)
                        .align(Alignment.TopEnd)
                        .background(color = LmColor.primary, shape = CircleShape)
                )
            }
        }
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithLogo(showBackIcon: Boolean = true, onBackClick: () -> Unit = {}) {
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