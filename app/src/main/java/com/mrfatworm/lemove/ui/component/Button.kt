package com.mrfatworm.lemove.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrfatworm.lemove.R
import com.mrfatworm.lemove.ui.theme.LmColor
import com.mrfatworm.lemove.ui.theme.Radius
import com.mrfatworm.lemove.ui.theme.Spacing
import com.mrfatworm.lemove.ui.theme.Typography

@Preview
@Composable
fun LmButton(
    modifier: Modifier = Modifier,
    text: String = "Button",
    hasIcon: Boolean = false,
    @DrawableRes iconId: Int = R.drawable.ic_home,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier.height(46.dp),
        shape = RoundedCornerShape(Radius.M),
        colors = ButtonColors(
            containerColor = LmColor.buttonPrimaryDefault,
            contentColor = LmColor.buttonOnPrimary,
            disabledContainerColor = LmColor.disable,
            disabledContentColor = LmColor.onDisable
        ),
        onClick = onClick
    ) {
        if (hasIcon) {
            Icon(modifier = Modifier.padding(end = Spacing.XXS).size(20.dp), painter = painterResource(id = iconId), contentDescription = "")
        }
        Text(
            text = text, style = Typography().button
        )
    }
}