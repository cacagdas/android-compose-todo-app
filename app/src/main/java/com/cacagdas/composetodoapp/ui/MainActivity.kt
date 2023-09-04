package com.cacagdas.composetodoapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cacagdas.composetodoapp.navigation.SetupNavigation
import com.cacagdas.composetodoapp.ui.theme.ComposeToDoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeToDoAppTheme {
                navHostController = rememberNavController()
                SetupNavigation(navHostController)
            }
        }
    }
}
