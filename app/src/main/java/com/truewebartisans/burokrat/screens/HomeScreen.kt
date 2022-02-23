package com.truewebartisans.burokrat.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.truewebartisans.burokrat.R
import com.truewebartisans.burokrat.Routes
import com.truewebartisans.burokrat.ui.theme.*

@Composable
fun HomeScreen(navController: NavHostController) {

    val sampleList = List(100) { "$it" }

    Scaffold(
        content = {
            Surface(color = MaterialTheme.colors.background) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        Text(
                            stringResource(R.string.my_journals),
                            style = headerTextStyle,
                            modifier = headerTextModifier
                        )
                    }
                    if (!sampleList.isNotEmpty()) {
                        items(sampleList) {
                            JournalCard(it)
                        }
                    } else {
                        item {
                            JournalCard("Oops... Journals not found!\nCreate a new one now :)")
                        }
                    }
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                icon = { Icon(Icons.Filled.Add, contentDescription = stringResource(R.string.create_new)) },
                text = { Text(stringResource(R.string.create_new)) },
                onClick = { navController.navigate(Routes.Settings.route) }
            )
        }
    )
}

@Composable
fun JournalCard(text: String) {
    Card(
        elevation = cardElevation,
        shape = cardShape,
        modifier = cardModifier
    ) {
        Text(text = text, modifier = cardTextModifier)
    }
}