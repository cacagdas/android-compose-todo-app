package com.cacagdas.composetodoapp.ui.screen.task

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cacagdas.composetodoapp.data.model.Priority
import com.cacagdas.composetodoapp.data.model.ToDoTask
import com.cacagdas.composetodoapp.util.Action

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit,
) {
    Scaffold(
        topBar = {
            TaskAppBar(selectedTask) {
                navigateToListScreen.invoke(it)
            }
        },
        content = {
            Box(
                modifier =
                Modifier.padding(
                    PaddingValues(top = it.calculateTopPadding()),
                )
            ) {
                TaskContent(
                    title = "",
                    description = "",
                    priority = Priority.LOW,
                    onTitleChanged = {},
                    onDescriptionChanged = {},
                    onPrioritySelected = {},
                )
            }
        },
    )
}
