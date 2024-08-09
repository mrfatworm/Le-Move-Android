package com.mrfatworm.lemove.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.mrfatworm.lemove.onboarding.OnboardingIntroScreen
import com.mrfatworm.lemove.splash.SplashScreen

@Composable
fun LeMoveNavGraph(
    navController: NavHostController, navActions: LeMoveNavActions
) {
    NavHost(navController = navController, startDestination = "splash") {
        composable(route = "splash") {
            SplashScreen(gotoMainScreen = {
                navController.navigate("onboarding") {
                    popUpTo("splash") {
                        inclusive = true
                    }
                }
            })
        }
        navigation(route = "onboarding", startDestination = "onboard_intro") {
            composable("onboard_intro") {
                OnboardingIntroScreen()
            }
        }
    }
}