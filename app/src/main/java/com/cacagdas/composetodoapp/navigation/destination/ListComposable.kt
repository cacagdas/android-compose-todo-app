package com.cacagdas.composetodoapp.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.cacagdas.composetodoapp.ui.SharedViewModel
import com.cacagdas.composetodoapp.ui.screen.list.ListScreen
import com.cacagdas.composetodoapp.util.Constants.LIST_ARG_KEY
import com.cacagdas.composetodoapp.util.Constants.LIST_SCREEN

fun NavGraphBuilder.listComposable(
    sharedViewModel: SharedViewModel,
    navigateToTaskScreen: (taskId: Int) -> Unit,
) {
    composable(
        route = LIST_SCREEN,
        arguments =
            listOf(
                navArgument(LIST_ARG_KEY) {
                    type = NavType.StringType
                },
            ),
    ) {
        ListScreen(sharedViewModel, navigateToTaskScreen)
    }
}
