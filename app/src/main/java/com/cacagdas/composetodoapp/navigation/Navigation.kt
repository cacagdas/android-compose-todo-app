package com.cacagdas.composetodoapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.cacagdas.composetodoapp.navigation.destination.listComposable
import com.cacagdas.composetodoapp.navigation.destination.taskComposable
import com.cacagdas.composetodoapp.ui.SharedViewModel
import com.cacagdas.composetodoapp.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel,
) {
    val screen =
        remember(navHostController) {
            Screens(navController = navHostController)
        }

    NavHost(
        navController = navHostController,
        startDestination = LIST_SCREEN,
    ) {
        listComposable(sharedViewModel, screen.task)
        taskComposable(screen.list)
    }
}
