package com.truewebartisans.burokrat.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = BlueDark,
    secondary = BlueDark,
    background = Black
)

private val LightColorPalette = lightColors(
    primary = BlueLight,
    secondary = BlueLight,
    background = White
)

@Composable
fun BurokratTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {

    val systemUiController = rememberSystemUiController()

    SideEffect {
        // Change color for system status bar:
        systemUiController.setSystemBarsColor(
            color = if (darkTheme) Black else White,
            darkIcons = !darkTheme
        )
    }

    MaterialTheme(
        colors = if (darkTheme) DarkColorPalette else LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}