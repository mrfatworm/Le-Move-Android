package com.mrfatworm.lemove.ui.component

import androidx.compose.foundation.Image
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.mrfatworm.lemove.R

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