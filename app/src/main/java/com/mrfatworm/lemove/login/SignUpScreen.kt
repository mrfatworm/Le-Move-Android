/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove.login

import android.util.Patterns
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.mrfatworm.lemove.R
import com.mrfatworm.lemove.ui.component.LmTextFiled
import com.mrfatworm.lemove.ui.component.PrimaryButton
import com.mrfatworm.lemove.ui.theme.LeMoveTheme
import com.mrfatworm.lemove.ui.theme.LmColor
import com.mrfatworm.lemove.ui.theme.LmTypography
import com.mrfatworm.lemove.ui.theme.Spacing

@Composable
fun SignUpScreen(modifier: Modifier = Modifier, onNextClick: () -> Unit = {}) {
    val emailText = remember { mutableStateOf("") }
    val passwordText = remember { mutableStateOf("") }
    val emailError = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = Spacing.S24, end = Spacing.S24, top = Spacing.S32),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(Spacing.S32),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.sign_up_announcement),
                style = LmTypography.Caption,
                color = LmColor.textSecondary
            )
            Column(verticalArrangement = Arrangement.spacedBy(Spacing.S12)) {
                LmTextFiled(
                    modifier = Modifier.fillMaxWidth(),
                    text = emailText.value,
                    title = stringResource(id = R.string.account),
                    onTextChange = {
                        emailText.value = it
                        emailError.value =
                            !emailText.value.matches(Patterns.EMAIL_ADDRESS.toRegex())
                    },
                    placeholder = stringResource(
                        R.string.email
                    ),
                    error = emailError.value,
                    message = stringResource(id = R.string.invalid_email),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
                    )
                )

                LmTextFiled(
                    modifier = Modifier.fillMaxWidth(),
                    text = passwordText.value,
                    title = stringResource(id = R.string.password),
                    onTextChange = {
                        passwordText.value = it
                    },
                    placeholder = stringResource(
                        R.string.password_en
                    ),
                    hint = stringResource(id = R.string.password_rule),
                    isPassword = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password, imeAction = ImeAction.Done
                    )
                )
            }

            Column(
                modifier = Modifier.imePadding(),
                verticalArrangement = Arrangement.spacedBy(Spacing.S12),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PrimaryButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .imePadding(),
                    text = stringResource(id = R.string.sign_up_by_email),
                    enabled = emailText.value.matches(Patterns.EMAIL_ADDRESS.toRegex()) && (passwordText.value.length in 8..12),
                    onClick = onNextClick
                )

                Row {
                    Text(
                        text = stringResource(id = R.string.sign_up_has_account),
                        color = LmColor.textTertiary,
                        style = LmTypography.Caption
                    )
                    Text(
                        modifier = Modifier.padding(start = Spacing.S4),
                        text = stringResource(id = R.string.sign_in),
                        style = LmTypography.Caption,
                        color = LmColor.primary
                    )
                }
            }
        }
        Column(modifier = Modifier.padding(bottom = Spacing.S32), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id = R.string.sign_up_agreement),
                color = LmColor.textTertiary,
                style = LmTypography.Caption
            )
            Row {
                Text(
                    modifier = Modifier.padding(start = Spacing.S4),
                    text = stringResource(id = R.string.sign_up_agreement_rule),
                    style = LmTypography.Caption,
                    color = LmColor.primary
                )
                Text(
                    text = stringResource(id = R.string.and),
                    color = LmColor.textTertiary,
                    style = LmTypography.Caption
                )
                Text(
                    modifier = Modifier.padding(start = Spacing.S4),
                    text = stringResource(id = R.string.sign_up_agreement_policy),
                    style = LmTypography.Caption,
                    color = LmColor.primary
                )
            }
        }

    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    LeMoveTheme {
        Surface(color = LmColor.surface) {
            SignUpScreen()
        }
    }
}