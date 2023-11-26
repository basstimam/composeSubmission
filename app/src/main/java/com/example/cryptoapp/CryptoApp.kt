package com.example.cryptoapp

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cryptoapp.ui.theme.navigation.Screen
import com.example.cryptoapp.ui.theme.screen.about.AboutScreen
import com.example.cryptoapp.ui.theme.screen.detail.DetailScreen
import com.example.cryptoapp.ui.theme.screen.home.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CryptoApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()

) {

    val currentDestination by navController.currentBackStackEntryAsState()
    val isAboutScreen = currentDestination?.destination?.route == Screen.About.route

    Scaffold(
        floatingActionButton = {
            if (!isAboutScreen) {
                FloatingActionButton(
                    onClick = { navController.navigate(Screen.About.route) },
                    modifier = Modifier.padding(bottom = 30.dp, end = 24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = stringResource(id = R.string.about_page_icon),
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        },



    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { coinId ->
                        navController.navigate(Screen.DetailCoin.createRoute(coinId))
                    }
                )
            }
            composable(
                Screen.DetailCoin.route,
                arguments = listOf(navArgument("coinId") { type = NavType.StringType }),
            ) {
                DetailScreen(
                    coinId = it.arguments?.getString("coinId") ?: "",
                    navigateBack = { navController.popBackStack() }
                )
            }

            composable(Screen.About.route) {
                AboutScreen()
            }
        }








    }
}