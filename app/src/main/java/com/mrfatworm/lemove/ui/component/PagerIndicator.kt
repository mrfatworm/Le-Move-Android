/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.mrfatworm.lemove.ui.theme.LmColor
import com.mrfatworm.lemove.ui.theme.Spacing
import com.mrfatworm.lemove.ui.theme.neutral200

@Composable
fun PagerIndicator(modifier: Modifier, pageCount: Int, currentPage: Int) {
    Row(
        modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pageCount) { iteration ->
            val color = if (currentPage == iteration) LmColor.primary else neutral200
            val size = if (currentPage == iteration) 20.dp else 6.dp
            Box(
                modifier = Modifier
                    .padding(horizontal = Spacing.XXS)
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = color)
                    .size(height = 6.dp, width = size)
            )
        }
    }
}