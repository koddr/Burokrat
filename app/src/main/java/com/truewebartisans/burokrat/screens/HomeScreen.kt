package com.truewebartisans.burokrat.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.truewebartisans.burokrat.R
import com.truewebartisans.burokrat.Routes
import com.truewebartisans.burokrat.elements.EmojiElement
import com.truewebartisans.burokrat.ui.theme.*

@Composable
fun HomeScreen(navController: NavHostController) {

    val sampleList = listOf(
        mapOf(
            "emoji" to EmojiElement.HEARTH.emoji,
            "text" to "Lorem ipsum dollor sit amet"
        ),
        mapOf(
            "emoji" to EmojiElement.FIRE.emoji,
            "text" to "Lorem ipsum dollor sit amet"
        ),
        mapOf(
            "emoji" to EmojiElement.RAINBOW.emoji,
            "text" to "Lorem ipsum dollor sit amet"
        )
    )

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
                    if (sampleList.isNotEmpty()) {
                        itemsIndexed(sampleList) { _, item ->
                            JournalCard(item["emoji"].toString(), item["text"].toString())
                        }
                    } else {
                        item {
                            JournalCard(EmojiElement.WOMAN_IDK.emoji, "Oops... Journals not found!\nCreate a new one now :)")
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
fun JournalCard(emoji: String, text: String) {
    Card(
        elevation = cardElevation,
        shape = cardShape,
        modifier = cardModifier
    ) {
        Row {
            Column(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(
                    text = emoji,
                    style = cardEmojiTextStyle,
                    modifier = cardEmojiModifier
                )
            }
            Column(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(
                    text = text,
                    modifier = cardTextModifier
                )
            }
        }
    }
    
}