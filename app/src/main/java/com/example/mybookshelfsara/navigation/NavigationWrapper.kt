package com.example.mybookshelfsara.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.mybookshelfsara.navigation.Routes.*
import com.example.mybookshelfsara.screens.LoginScreen

@Composable
fun NavigationWrapper() {
    val backStack  = rememberNavBackStack(Routes.Login)
    NavDisplay(
        backStack = backStack,
        onBack = {backStack.removeAt(backStack.lastIndex)},
        entryProvider = entryProvider {
            entry<Login>{
                LoginScreen()
            }
            entry<Home>{
            }
        }
    )
}