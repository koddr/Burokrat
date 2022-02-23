package com.truewebartisans.burokrat.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Header:
val headerTextStyle = Typography.h1
val headerTextModifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)

// Lazy column:
val lazyColumnItemBoxModifier = Modifier.height(74.dp)

// Card:
val cardElevation = 4.dp
val cardShape = Shapes.large
val cardModifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp).fillMaxSize()
val cardEmojiModifier = Modifier.padding(start = 20.dp)
val cardEmojiTextStyle = Typography.h5
val cardTextModifier = Modifier.padding(20.dp)
