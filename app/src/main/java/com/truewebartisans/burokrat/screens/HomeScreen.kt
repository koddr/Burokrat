package com.truewebartisans.burokrat.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
            "emoji" to EmojiElement.DEFAULT.code,
            "text" to "Lorem ipsum dollor sit amet Lorem ipsum dollor sit amet Lorem ipsum dollor sit amet"
        ),
        mapOf(
            "emoji" to EmojiElement.HEARTH.code,
            "text" to "Lorem ipsum dollor sit amet"
        ),
        mapOf(
            "emoji" to EmojiElement.SHOPPING.code,
            "text" to "Lorem ipsum dollor sit amet"
        ),
        mapOf(
            "emoji" to EmojiElement.HUNDRED.code,
            "text" to "Lorem ipsum dollor sit amet"
        ),
        mapOf(
            "emoji" to EmojiElement.FIRE.code,
            "text" to "Lorem ipsum dollor sit amet Lorem ipsum dollor sit amet Lorem ipsum dollor sit amet Lorem ipsum dollor sit amet"
        ),
        mapOf(
            "emoji" to EmojiElement.COIN.code,
            "text" to "Lorem ipsum dollor sit amet"
        ),
        mapOf(
            "emoji" to EmojiElement.IDEA.code,
            "text" to "Lorem ipsum dollor sit amet"
        ),
        mapOf(
            "emoji" to EmojiElement.PHOTO.code,
            "text" to "Lorem ipsum dollor sit amet"
        ),
        mapOf(
            "emoji" to EmojiElement.PARTY.code,
            "text" to "Lorem ipsum dollor sit amet Lorem ipsum dollor sit amet"
        ),
        mapOf(
            "emoji" to EmojiElement.PILL.code,
            "text" to "Lorem ipsum dollor sit amet"
        ),
        mapOf(
            "emoji" to EmojiElement.RAINBOW.code,
            "text" to "Lorem ipsum dollor sit amet"
        ),
        mapOf(
            "emoji" to EmojiElement.STUDY.code,
            "text" to "Lorem ipsum dollor sit amet"
        ),
        mapOf(
            "emoji" to EmojiElement.MOVIE.code,
            "text" to "Lorem ipsum dollor sit amet"
        )
    )

    Scaffold(
        content = {
            Surface(
                color = MaterialTheme.colors.background
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    item {
                        Text(
                            stringResource(R.string.my_journals),
                            style = headerTextStyle,
                            modifier = headerTextModifier
                        )
                    }
                    if (sampleList.isNotEmpty()) {
                        itemsIndexed(sampleList) { _, item ->
                            JournalCard(
                                item["emoji"].toString(),
                                item["text"].toString()
                            )
                        }
                    } else {
                        item {
                            JournalCard(
                                EmojiElement.WOMAN_IDK.code,
                                stringResource(R.string.oops_not_found_journals)
                            )
                        }
                    }
                    item {
                        Box(modifier = lazyColumnItemBoxModifier.background(MaterialTheme.colors.background))
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