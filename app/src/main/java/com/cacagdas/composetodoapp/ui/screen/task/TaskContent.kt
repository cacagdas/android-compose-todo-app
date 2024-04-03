package com.cacagdas.composetodoapp.ui.screen.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cacagdas.composetodoapp.R
import com.cacagdas.composetodoapp.data.model.Priority
import com.cacagdas.composetodoapp.ui.theme.PADDING_16
import com.cacagdas.composetodoapp.ui.theme.PADDING_8
import com.cacagdas.composetodoapp.uicomponents.PriorityDropdown

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskContent(
    title: String,
    description: String,
    priority: Priority,
    onTitleChanged: (String) -> Unit,
    onDescriptionChanged: (String) -> Unit,
    onPrioritySelected: (Priority) -> Unit,
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(PADDING_16),
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = {
                onTitleChanged(it)
            },
            label = {
                Text(text = stringResource(R.string.title))
            },
            textStyle = MaterialTheme.typography.bodySmall,
            singleLine = true,
        )
        Divider(
            modifier = Modifier.height(PADDING_8),
            color = MaterialTheme.colorScheme.background,
        )
        PriorityDropdown(priority, onPrioritySelected)
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = description,
            onValueChange = {
                onDescriptionChanged(it)
            },
            label = {
                Text(text = stringResource(R.string.description))
            },
            textStyle = MaterialTheme.typography.bodySmall,
        )
    }
}

@Composable
@Preview
fun TaskContentPreview() {
    TaskContent(
        title = "",
        description = "",
        priority = Priority.LOW,
        onTitleChanged = {},
        onDescriptionChanged = {},
        onPrioritySelected = {},
    )
}
