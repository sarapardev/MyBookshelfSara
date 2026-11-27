package com.example.mybookshelfsara.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.mybookshelfsara.navigation.Routes.*
import com.example.mybookshelfsara.screens.HomeScreen
import com.example.mybookshelfsara.screens.LoginScreen

@Composable
fun NavigationWrapper() {
    val backStack = rememberNavBackStack(Routes.Login)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Login> {
                LoginScreen() {userName ->
                    backStack.add(Routes.Home(userName))
                }
            }
            entry<Routes.Home> { key ->
                HomeScreen(key.name) {
                    backStack.removeLastOrNull() ?: Routes.Login
                }
            }
        }
    )
}