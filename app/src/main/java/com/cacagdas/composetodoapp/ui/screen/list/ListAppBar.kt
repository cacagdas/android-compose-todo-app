package com.cacagdas.composetodoapp.ui.screen.list

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cacagdas.composetodoapp.R
import com.cacagdas.composetodoapp.data.model.Priority
import com.cacagdas.composetodoapp.ui.theme.topAppBarBackgroundColor
import com.cacagdas.composetodoapp.ui.theme.topAppBarContentColor
import com.cacagdas.composetodoapp.uicomponents.PriorityItem

@Composable
fun ListAppBar() {
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
) {
    TopAppBar(
        title = {
            Text(text = "Tasks", color = MaterialTheme.colorScheme.topAppBarContentColor)
        },
        actions = {
            ListAppBarActions(
                onSearchClicked,
                onSortClicked,
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onSecondary,
            scrolledContainerColor = MaterialTheme.colorScheme.onPrimary,
        ),
    )
}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
) {
    SearchAction(onSearchClicked)
    SortAction(onSortClicked)
}

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit,
) {
    IconButton(onClick = { onSearchClicked() }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(R.string.search_action),
            tint = MaterialTheme.colorScheme.topAppBarContentColor,
        )
    }
}

@Composable
fun SortAction(
    onSortClicked: (Priority) -> Unit,
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    IconButton(onClick = {
        expanded = true
    }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter_list),
            contentDescription = stringResource(R.string.sort_action),
            tint = MaterialTheme.colorScheme.topAppBarContentColor,
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            },
        ) {
            DropdownMenuItem(
                text = {
                    PriorityItem(priority = Priority.HIGH)
                },
                onClick = {
                    expanded = false
                    onSortClicked(Priority.HIGH)
                },
            )
            DropdownMenuItem(
                text = {
                    PriorityItem(priority = Priority.MEDIUM)
                },
                onClick = {
                    expanded = false
                    onSortClicked(Priority.MEDIUM)
                },
            )
            DropdownMenuItem(
                text = {
                    PriorityItem(priority = Priority.LOW)
                },
                onClick = {
                    expanded = false
                    onSortClicked(Priority.LOW)
                },
            )
            DropdownMenuItem(
                text = {
                    PriorityItem(priority = Priority.NONE)
                },
                onClick = {
                    expanded = false
                    onSortClicked(Priority.NONE)
                },
            )
        }
    }
}

@Composable
@Preview
private fun DefaultListAppBarPreview() {
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
    )
}
