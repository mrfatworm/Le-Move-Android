/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mrfatworm.lemove.login.SignUpScreen
import com.mrfatworm.lemove.onboarding.ChooseStyleScreen
import com.mrfatworm.lemove.onboarding.OnboardNameScreen
import com.mrfatworm.lemove.onboarding.OnboardingIntro2Screen
import com.mrfatworm.lemove.onboarding.OnboardingIntro3Screen
import com.mrfatworm.lemove.onboarding.OnboardingIntroScreen
import com.mrfatworm.lemove.sport.SportScreen
import com.mrfatworm.lemove.ui.component.TopBarWithLogo
import com.mrfatworm.lemove.ui.theme.LmColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardNavGraph(
    navActions: LeMoveNavActions, onLoginClick: () -> Unit = {}
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val selectedDestination = navBackStackEntry?.destination?.route ?: Screen.Home.route
    val firstPagerState = rememberPagerState(pageCount = { 3 })
    val coroutineScope = rememberCoroutineScope()

    Scaffold(topBar = {
        TopBarWithLogo(showBackIcon = firstPagerState.currentPage != 0, onBackClick = {
            if (selectedDestination == Screen.OnboardIntro.route) coroutineScope.launch {
                firstPagerState.animateScrollToPage(firstPagerState.currentPage - 1)
            } else {
                navController.popBackStack()
            }
        })
    }) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = LmColor.surface)
        ) {
            NavHost(navController = navController,
                route = Screen.OnboardFlow.route,
                startDestination = Screen.OnboardIntro.route,
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
                composable(Screen.OnboardIntro.route) {
                    OnboardingIntroScreen(pagerState = firstPagerState, onNextClick = {
                        navController.navigate(Screen.OnboardFiledName.route)
                    }, onLoginClick = onLoginClick)
                }
                composable(Screen.OnboardFiledName.route) {
                    OnboardNameScreen(onNextClick = { navController.navigate(Screen.OnboardExperience.route) })
                }
                composable(Screen.OnboardExperience.route) {
                    OnboardingIntro2Screen(onNextClick = { navController.navigate(Screen.OnboardNotification.route) },
                        onStartClick = {
                            navController.navigate(Screen.Sport.route)
                        })
                }
                composable(Screen.Sport.route) {
                    SportScreen()
                }

                composable(Screen.OnboardNotification.route) {
                    OnboardingIntro3Screen(onNextClick = {
                        navController.navigate(Screen.ChoseStyle.route)
                    })
                }

                composable(Screen.ChoseStyle.route) {
                    ChooseStyleScreen(onNextClick = {
                        navController.navigate(Screen.SignUp.route)
                    })
                }

                composable(Screen.SignUp.route) {
                    SignUpScreen(onNextClick = {
                        navController.navigate(Screen.MainFlow.route)
                    })
                }

                composable(Screen.Home.route) {
                    SignUpScreen(onNextClick = { navActions.navigationToTop(Screen.MainFlow) })
                }
            }
        }

    }

}