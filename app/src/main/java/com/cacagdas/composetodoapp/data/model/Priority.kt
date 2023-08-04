package com.cacagdas.composetodoapp.data.model

import androidx.compose.ui.graphics.Color
import com.cacagdas.composetodoapp.ui.theme.HighPriorityColor
import com.cacagdas.composetodoapp.ui.theme.LowPriorityColor
import com.cacagdas.composetodoapp.ui.theme.MediumPriorityColor
import com.cacagdas.composetodoapp.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor),
}
