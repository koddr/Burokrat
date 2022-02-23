package com.truewebartisans.burokrat.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.truewebartisans.burokrat.R
import com.truewebartisans.burokrat.Routes
import com.truewebartisans.burokrat.ui.theme.headerTextModifier
import com.truewebartisans.burokrat.ui.theme.headerTextStyle
import com.truewebartisans.burokrat.ui.theme.lazyColumnItemBoxModifier

@Composable
fun SettingsScreen(navController: NavHostController) {

    Scaffold(
        content = {
            Surface(color = MaterialTheme.colors.background) {
                Text(
                    stringResource(R.string.settings),
                    style = headerTextStyle,
                    modifier = headerTextModifier
                )
                Box(modifier = lazyColumnItemBoxModifier.background(MaterialTheme.colors.background))
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                icon = { Icon(Icons.Filled.Done, contentDescription = stringResource(R.string.save)) },
                text = { Text(stringResource(R.string.save)) },
                onClick = { navController.navigate(Routes.Home.route) }
            )
        }
    )
}
