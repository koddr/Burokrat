package com.truewebartisans.burokrat.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.truewebartisans.burokrat.R
import com.truewebartisans.burokrat.Routes

@Composable
fun SettingsScreen(navController: NavHostController) {

    // Define styles:
    val headerModifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)

    Scaffold(
        content = {
            Surface(color = MaterialTheme.colors.background) {
                CompositionLocalProvider(
                    LocalTextStyle provides MaterialTheme.typography.h1
                ) {
                    Text(stringResource(R.string.settings), modifier = headerModifier)
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                icon = { Icon(Icons.Filled.Done, contentDescription = null) },
                text = { Text(stringResource(R.string.save)) },
                onClick = { navController.navigate(Routes.Home.route) }
            )
        }
    )
}
