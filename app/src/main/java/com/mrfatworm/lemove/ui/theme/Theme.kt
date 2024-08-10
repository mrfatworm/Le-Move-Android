/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun LeMoveTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        content = {
            Surface(modifier = Modifier.fillMaxSize(), color = LmColor.surface) {
                content()
            }
        }
    )
}