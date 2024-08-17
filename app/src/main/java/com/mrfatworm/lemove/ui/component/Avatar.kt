package com.mrfatworm.lemove.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrfatworm.lemove.R
import com.mrfatworm.lemove.ui.theme.LeMoveTheme
import com.mrfatworm.lemove.ui.theme.LmColor
import com.mrfatworm.lemove.ui.theme.LmTypography
import com.mrfatworm.lemove.ui.theme.Spacing
import com.mrfatworm.lemove.ui.theme.neutral100

@Composable
fun Avatar(
    modifier: Modifier = Modifier, imgId: Int? = null, text: String, enable: Boolean = true
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Spacing.S4),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .size(52.dp)
                .border(
                    width = 1.dp,
                    shape = CircleShape,
                    color = if (enable) LmColor.primary else LmColor.borderNormal
                )
                .padding(4.dp)
                .clip(CircleShape), contentAlignment = Alignment.Center
        ) {
            if (imgId == null) {
                Spacer(
                    modifier = Modifier
                        .matchParentSize()
                        .background(neutral100)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = text,
                    tint = LmColor.onSurfaceContainer
                )
            } else {
                Image(
                    modifier = modifier
                        .matchParentSize()
                        .clip(CircleShape),
                    painter = painterResource(id = imgId),
                    contentDescription = text,
                    alpha = if (enable) 1f else 0.5f
                )
            }
        }


        Text(text = text, style = LmTypography.Caption, color = if (enable) LmColor.textSecondary else LmColor.textTertiary)
    }
}

@Preview
@Composable
fun AvatarPreview() {
    LeMoveTheme {
        Surface(color = LmColor.surface) {
            Avatar(imgId = R.drawable.img_avatar_miliy, text = "Milly")
        }
    }
}

@Preview
@Composable
fun AvatarDisablePreview() {
    LeMoveTheme {
        Surface(color = LmColor.surface) {
            Avatar(imgId = R.drawable.img_avatar_miliy, text = "Milly", enable = false)
        }
    }
}

@Preview
@Composable
fun AvatarNoneImagePreview() {
    LeMoveTheme {
        Surface(color = LmColor.surface) {
            Avatar(text = "Milly", enable = false)
        }
    }
}