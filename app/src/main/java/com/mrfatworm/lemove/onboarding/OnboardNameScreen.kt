/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import com.mrfatworm.lemove.R
import com.mrfatworm.lemove.ui.component.LmTextFiled
import com.mrfatworm.lemove.ui.component.PrimaryButton
import com.mrfatworm.lemove.ui.theme.LeMoveTheme
import com.mrfatworm.lemove.ui.theme.LmColor
import com.mrfatworm.lemove.ui.theme.LmTypography
import com.mrfatworm.lemove.ui.theme.Spacing

@Composable
fun OnboardNameScreen(modifier: Modifier = Modifier, onNextClick: () -> Unit = {}) {
    val textFieldText = remember { mutableStateOf("") }
    val textFieldError = remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = Spacing.S24, end = Spacing.S24, bottom = Spacing.S24),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = Spacing.S48),
                verticalArrangement = Arrangement.spacedBy(Spacing.S8),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.what_your_name),
                    style = LmTypography.Headline2,
                    color = LmColor.primary
                )
                LmTextFiled(
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester),
                    text = textFieldText.value,
                    onTextChange = {
                        textFieldText.value = it
                        textFieldError.value = it.length > 20
                    },
                    hint = stringResource(
                        R.string.your_name
                    ),
                    error = textFieldError.value,
                    message = stringResource(id = R.string.exceed_20_charactor),
                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words)
                )
            }
            PrimaryButton(modifier = Modifier
                .fillMaxWidth()
                .imePadding(),
                text = stringResource(id = R.string.continue_str),
                enabled = !textFieldError.value && textFieldText.value.isNotBlank(),
                onClick = onNextClick)
        }
        LaunchedEffect(true) {
            focusRequester.requestFocus()
        }
}

@Preview
@Composable
fun OnboardNameScreenPreview() {
    LeMoveTheme {
        OnboardNameScreen()
    }
}