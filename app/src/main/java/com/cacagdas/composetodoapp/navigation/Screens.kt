package com.cacagdas.composetodoapp.navigation

import androidx.navigation.NavHostController
import com.cacagdas.composetodoapp.util.Action
import com.cacagdas.composetodoapp.util.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {
    val list: (Action) -> Unit = {
        navController.navigate("list/${it.name}") {
            popUpTo(LIST_SCREEN) {
                inclusive = true
            }
        }
    }

    val task: (Int) -> Unit = {
        navController.navigate("task/$it")
    }
}
