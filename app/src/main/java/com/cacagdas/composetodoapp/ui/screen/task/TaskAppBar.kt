package com.cacagdas.composetodoapp.ui.screen.task

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.cacagdas.composetodoapp.R
import com.cacagdas.composetodoapp.data.model.Priority
import com.cacagdas.composetodoapp.data.model.ToDoTask
import com.cacagdas.composetodoapp.ui.theme.topAppBarBackgroundColor
import com.cacagdas.composetodoapp.ui.theme.topAppBarContentColor
import com.cacagdas.composetodoapp.util.Action

@Composable
fun TaskAppBar(navigateToListScreen: (Action) -> Unit) {
    NewTaskAppBar {
        navigateToListScreen.invoke(it)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTaskAppBar(navigateToListScreen: (Action) -> Unit) {
    TopAppBar(
        navigationIcon = {
            BackAction {
                navigateToListScreen.invoke(it)
            }
        },
        title = {
            Text(
                text = stringResource(R.string.add_task),
                color = MaterialTheme.colorScheme.topAppBarContentColor,
            )
        },
        colors =
            TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                actionIconContentColor = MaterialTheme.colorScheme.onSecondary,
                scrolledContainerColor = MaterialTheme.colorScheme.onPrimary,
            ),
        actions = {
            AddAction {
                navigateToListScreen.invoke(it)
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExistingTaskAppBar(
    task: ToDoTask,
    navigateToListScreen: (Action) -> Unit,
) {
    TopAppBar(
        navigationIcon = {
            CloseAction {
                navigateToListScreen.invoke(it)
            }
        },
        title = {
            Text(
                text = task.title,
                color = MaterialTheme.colorScheme.topAppBarContentColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        colors =
            TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                actionIconContentColor = MaterialTheme.colorScheme.onSecondary,
                scrolledContainerColor = MaterialTheme.colorScheme.onPrimary,
            ),
        actions = {
            DeleteAction {
                navigateToListScreen.invoke(it)
            }
            UpdateAction {
                navigateToListScreen.invoke(it)
            }
        },
    )
}

@Composable
fun BackAction(onBackClicked: (Action) -> Unit) {
    IconButton(onClick = { onBackClicked(Action.NO_ACTION) }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(R.string.back),
            tint = MaterialTheme.colorScheme.topAppBarContentColor,
        )
    }
}

@Composable
fun AddAction(onAddClicked: (Action) -> Unit) {
    IconButton(onClick = { onAddClicked(Action.ADD) }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(R.string.add_task),
            tint = MaterialTheme.colorScheme.topAppBarContentColor,
        )
    }
}

@Composable
fun CloseAction(onCloseClicked: (Action) -> Unit) {
    IconButton(onClick = { onCloseClicked(Action.NO_ACTION) }) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = stringResource(R.string.close_icon_content_desc),
            tint = MaterialTheme.colorScheme.topAppBarContentColor,
        )
    }
}

@Composable
fun DeleteAction(onDeleteClicked: (Action) -> Unit) {
    IconButton(onClick = { onDeleteClicked(Action.DELETE) }) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = stringResource(R.string.delete),
            tint = MaterialTheme.colorScheme.topAppBarContentColor,
        )
    }
}

@Composable
fun UpdateAction(onUpdateClicked: (Action) -> Unit) {
    IconButton(onClick = { onUpdateClicked(Action.UPDATE) }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(R.string.update),
            tint = MaterialTheme.colorScheme.topAppBarContentColor,
        )
    }
}

@Composable
@Preview
fun NewTaskAppBarPreview() {
    NewTaskAppBar {
    }
}

@Composable
@Preview
fun ExistingTaskAppBarPreview() {
    ExistingTaskAppBar(
        task =
            ToDoTask(
                0,
                "Title",
                "desc",
                Priority.LOW,
            ),
    ) {
    }
}
