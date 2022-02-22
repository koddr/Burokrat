package com.truewebartisans.burokrat

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Settings : Routes("settings")
}
