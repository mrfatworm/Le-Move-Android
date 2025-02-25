/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.mrfatworm.lemove.ui.navigation.LeMoveNavActions
import com.mrfatworm.lemove.ui.navigation.LeMoveNavGraph

@Composable
fun LeMoveApp() {
    val navController = rememberNavController()
    val navActions = remember(LeMoveNavActions(navController)) {
        LeMoveNavActions(navController)
    }

    LeMoveNavGraph(navController = navController, navActions)

}