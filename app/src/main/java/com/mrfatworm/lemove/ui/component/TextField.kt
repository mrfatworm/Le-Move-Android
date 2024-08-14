/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
    title: String? = null,
    hint: String? = null,
    placeholder: String,
    error: Boolean = false,
    message: String = "",
    enabled: Boolean = true,
    isPassword: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(Spacing.S8)) {
        if (title != null) {
            Text(text = title, style = LmTypography.Subtitle2, color = LmColor.textPrimary)
        }
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = onTextChange,
            placeholder = {
                Text(
                    text = placeholder, color = LmColor.textTertiary, style = LmTypography.Body2
                )
            },
            textStyle = LmTypography.Body2,
            enabled = enabled,
            isError = error,
            shape = RoundedCornerShape(Radius.R16),
            colors = textFiledColors(),
            keyboardOptions = keyboardOptions,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
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
        if (hint != null) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Spacing.S4)
            ) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.ic_info),
                    contentDescription = "",
                    tint = LmColor.textTertiary
                )
                Text(text = hint, color = LmColor.textTertiary, style = LmTypography.Caption)
            }
        }
        if (error) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Spacing.S4)
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
        text = "",
        onTextChange = {},
        title = "Account",
        placeholder = "Hint",
        error = false,
        message = ""
    )
}

@Preview
@Composable
fun ErrorPreview() {
    LmTextFiled(
        text = "",
        title = "Account",
        onTextChange = {},
        placeholder = "Hint",
        error = true,
        message = stringResource(R.string.exceed_20_charactor)
    )
}

@Preview
@Composable
fun DisablePreview() {
    LmTextFiled(
        text = "",
        title = "Account",
        onTextChange = {},
        placeholder = "Hint",
        enabled = false,
        error = false
    )
}