package com.cacagdas.composetodoapp.navigation.destination

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.cacagdas.composetodoapp.ui.SharedViewModel
import com.cacagdas.composetodoapp.ui.screen.task.TaskScreen
import com.cacagdas.composetodoapp.util.Action
import com.cacagdas.composetodoapp.util.Constants.TASK_ARG_KEY
import com.cacagdas.composetodoapp.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit,
) {
    composable(
        route = TASK_SCREEN,
        arguments =
            listOf(
                navArgument(TASK_ARG_KEY) {
                    type = NavType.IntType
                },
            ),
    ) {
        val taskId = it.arguments?.getInt(TASK_ARG_KEY)
        taskId?.let { id -> sharedViewModel.getSelectedTask(id) }
        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        LaunchedEffect(key1 = taskId) {
            sharedViewModel.updateTaskFields(selectedTask)
        }

        TaskScreen(sharedViewModel, selectedTask) { action ->
            navigateToListScreen.invoke(action)
        }
    }
}
