package com.truewebartisans.burokrat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.truewebartisans.burokrat.screens.HomeScreen
import com.truewebartisans.burokrat.screens.SettingsScreen
import com.truewebartisans.burokrat.ui.theme.BurokratTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            BurokratTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Routes.Home.route
                    ) {
                        composable(Routes.Home.route) { HomeScreen(navController) }
                        composable(Routes.Settings.route) { SettingsScreen(navController) }
                    }
                }
            }
        }
    }
}