package com.cacagdas.composetodoapp.ui.screen.task

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.cacagdas.composetodoapp.data.model.Priority
import com.cacagdas.composetodoapp.data.model.ToDoTask
import com.cacagdas.composetodoapp.ui.SharedViewModel
import com.cacagdas.composetodoapp.util.Action

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(
    sharedViewModel: SharedViewModel,
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit,
) {
    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    Scaffold(
        topBar = {
            TaskAppBar(selectedTask) {
                navigateToListScreen.invoke(it)
            }
        },
        content = { paddingValues ->
            Box(
                modifier =
                    Modifier.padding(
                        PaddingValues(top = paddingValues.calculateTopPadding()),
                    ),
            ) {
                TaskContent(
                    title = title,
                    description = description,
                    priority = priority,
                    onTitleChanged = {
                        sharedViewModel.title.value = it
                    },
                    onDescriptionChanged = {
                        sharedViewModel.description.value = it
                    },
                    onPrioritySelected = {
                        sharedViewModel.priority.value = it
                    },
                )
            }
        },
    )
}
