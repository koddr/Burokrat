package com.truewebartisans.burokrat.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.truewebartisans.burokrat.R
import com.truewebartisans.burokrat.Routes

@Composable
fun HomeScreen(navController: NavHostController) {

    val sampleList = List(100) { "$it" }

    // Define styles:
    val headerModifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)

    Scaffold(
        content = {
            Surface(color = MaterialTheme.colors.background) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        CompositionLocalProvider(
                            LocalTextStyle provides MaterialTheme.typography.h1
                        ) {
                            Text(stringResource(R.string.my_journals), modifier = headerModifier)
                        }
                    }
                    items(sampleList) { item ->
                        JournalCard(item)
                    }
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                icon = { Icon(Icons.Filled.Add, contentDescription = null) },
                text = { Text(stringResource(R.string.create_new)) },
                onClick = { navController.navigate(Routes.Settings.route) }
            )
        }
    )
}

@Composable
fun JournalCard(text: String) {
    Card(
        elevation = 4.dp,
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp).fillMaxSize()
    ) {
        Text(text = text, modifier = Modifier.padding(20.dp))
    }
}