package com.example.cryptoapp.ui.theme.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object DetailCoin : Screen("home/{coinId}") {
        fun createRoute(coinId: String) = "home/$coinId"
    }
    object  About: Screen("about")
}