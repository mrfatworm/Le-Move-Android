/*
 * Copyright 2024 The Le Move Open Source Project by mrfatworm
 * License: Apache-2.0
 */

package com.mrfatworm.lemove.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.navigation.NamedNavArgument
import com.mrfatworm.lemove.R

sealed class Screen(
    val route: String,
    @StringRes val textId: Int = 0,
    @DrawableRes val icon: Int = 0,
    val navArgs: List<NamedNavArgument> = emptyList()
) {
    data object Splash : Screen("splash")
    data object OnboardIntro : Screen("onboard_intro")
    data object OnboardFiledName : Screen("onboard_filed_name")
    data object OnboardExperience : Screen("onboard_experience")
    data object OnboardNotification : Screen("onboard_notification")
    data object ChoseStyle : Screen("chose_style")
    data object SignUp : Screen("sign_up")
    data object SignIn : Screen("sign_in")
    data object OnboardReady : Screen("onboard_ready")
    data object Home : Screen("home", R.string.home, R.drawable.ic_home)
    data object Explore : Screen("explore", R.string.explore, R.drawable.ic_explore)
    data object Profile : Screen("profile", R.string.profile, R.drawable.ic_profile)
    data object Friends : Screen("friends", R.string.my_friends)
    data object MyCollection : Screen("my_collection", R.string.my_collection)
    data object Settings : Screen("settings", R.string.notification_setting)
    data object SportPrepare : Screen("sport_prepare")
}

val BottomScreens = listOf(
    Screen.Home, Screen.Explore, Screen.Profile
)