/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrfatworm.lemove.R
import com.mrfatworm.lemove.ui.theme.LmColor
import com.mrfatworm.lemove.ui.theme.LmTypography
import com.mrfatworm.lemove.ui.theme.Radius
import com.mrfatworm.lemove.ui.theme.Spacing

@Composable
fun LmTextFiled(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    hint: String,
    error: Boolean = false,
    message: String = "",
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    Column(modifier = modifier) {
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = onTextChange,
            placeholder = { Text(text = hint) },
            textStyle = LmTypography.Body2,
            enabled = enabled,
            isError = error,
            shape = RoundedCornerShape(Radius.M),
            colors = textFiledColors(),
            keyboardOptions = keyboardOptions,
            trailingIcon = {
                if (text.isNotBlank()) {
                    IconButton(onClick = { onTextChange("") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_close),
                            contentDescription = "close"
                        )
                    }
                }
            })
        if (error) {
            Row(
                modifier = Modifier.padding(top = Spacing.XS),
                horizontalArrangement = Arrangement.spacedBy(Spacing.XXS)
            ) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.ic_error),
                    contentDescription = "",
                    tint = LmColor.error
                )
                Text(text = message, color = LmColor.error, style = LmTypography.Caption)
            }
        }
    }
}

@Composable
fun textFiledColors() = OutlinedTextFieldDefaults.colors(
    focusedTextColor = LmColor.textPrimary,
    focusedContainerColor = LmColor.surface,
    focusedBorderColor = LmColor.primary,
    unfocusedTextColor = LmColor.textPrimary,
    unfocusedContainerColor = LmColor.surface,
    unfocusedBorderColor = LmColor.borderNormal,
    errorTextColor = LmColor.textPrimary,
    errorContainerColor = LmColor.onError,
    errorCursorColor = LmColor.error,
    cursorColor = LmColor.onSurfaceContainer,
    disabledTextColor = LmColor.textTertiary,
    disabledContainerColor = LmColor.surfaceContainer,
    disabledBorderColor = LmColor.borderNormal
)

@Preview
@Composable
fun NormalPreview() {
    LmTextFiled(
        text = "", onTextChange = {}, hint = "Hint", error = false, message = ""
    )
}

@Preview
@Composable
fun ErrorPreview() {
    LmTextFiled(
        text = "",
        onTextChange = {},
        hint = "Hint",
        error = true,
        message = stringResource(R.string.exceed_20_charactor)
    )
}

@Preview
@Composable
fun DisablePreview() {
    LmTextFiled(
        text = "", onTextChange = {}, hint = "Hint", enabled = false, error = false
    )
}