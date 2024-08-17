/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mrfatworm.lemove.splash.SplashScreen

@Composable
fun LeMoveNavGraph(
    navController: NavHostController, navActions: LeMoveNavActions
) {
    NavHost(navController = navController,
        startDestination = Screen.Splash.route,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Start, tween(500)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.End, tween(500)
            )
        }) {
        composable(route = Screen.Splash.route) {
            SplashScreen(gotoMainScreen = {
                navActions.navigationToTop(Screen.OnboardFlow)
            })
        }
        composable(route = Screen.OnboardFlow.route) {
            OnboardNavGraph(navActions = navActions, onLoginClick = {
                navActions.navigationAndClearBackStack(Screen.MainFlow)
            })
        }

        composable(route = Screen.MainFlow.route) {
            MainNavGraph(rootNavActions = navActions)
        }
    }
}