package com.mrfatworm.lemove.ui.navigation

import androidx.navigation.NavHostController

class LeMoveNavActions(private val navController: NavHostController) {

    fun navigationToTopAndSave(destination: Screen) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}