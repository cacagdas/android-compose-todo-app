package com.cacagdas.composetodoapp.uicomponents

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cacagdas.composetodoapp.data.model.Priority
import com.cacagdas.composetodoapp.ui.theme.PADDING_8
import com.cacagdas.composetodoapp.ui.theme.SIZE_16

@Composable
fun PriorityItem(priority: Priority) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Canvas(modifier = Modifier.size(SIZE_16)) {
            drawCircle(
                color = priority.color,
            )
        }
        Text(
            modifier = Modifier.padding(start = PADDING_8),
            text = priority.name,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}

@Composable
@Preview
fun PriorityItemPreview() {
    PriorityItem(priority = Priority.HIGH)
}
