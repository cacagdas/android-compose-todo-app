package com.cacagdas.composetodoapp.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.cacagdas.composetodoapp.util.Action
import com.cacagdas.composetodoapp.util.Constants.TASK_ARG_KEY
import com.cacagdas.composetodoapp.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit,
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(
            navArgument(TASK_ARG_KEY) {
                type = NavType.IntType
            },
        ),
    ) {
        //
    }
}
