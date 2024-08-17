/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mrfatworm.lemove.R
import com.mrfatworm.lemove.main.ExploreScreen
import com.mrfatworm.lemove.main.HomeScreen
import com.mrfatworm.lemove.main.ProfileScreen
import com.mrfatworm.lemove.ui.component.HomeTopBar
import com.mrfatworm.lemove.ui.component.LeMoveBottomNavigation
import com.mrfatworm.lemove.ui.theme.LmColor

@Composable
fun MainNavGraph(
    rootNavActions: LeMoveNavActions
) {
    val navController = rememberNavController()
    val navActions = remember(LeMoveNavActions(navController)) {
        LeMoveNavActions(navController)
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val selectedDestination = navBackStackEntry?.destination?.route ?: Screen.Home.route

    Scaffold(topBar = {
        if (selectedDestination == Screen.Home.route) {
            HomeTopBar(titleId = R.string.home_title_01)
        }
    }, bottomBar = {
        LeMoveBottomNavigation(selectedDestination = selectedDestination, navActions = navActions)
    }) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = LmColor.surface)
        ) {
            NavHost(navController = navController,
                route = Screen.MainFlow.route,
                startDestination = Screen.Home.route) {

                composable(Screen.Home.route) {
                    HomeScreen()
                }

                composable(Screen.Explore.route) {
                    ExploreScreen()
                }

                composable(Screen.Profile.route) {
                    ProfileScreen()
                }
            }
        }

    }

}