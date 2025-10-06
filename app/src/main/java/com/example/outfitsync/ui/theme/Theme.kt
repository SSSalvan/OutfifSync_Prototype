package com.example.outfitsync

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Pink,
    onPrimary = Beige,
    secondary = Accent,
    background = Beige,
    onBackground = DarkText,
    surface = Color.White,
    onSurface = DarkText
)

@Composable
fun OutfitSyncTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = androidx.compose.material3.Typography(), // use defaults or define
        shapes = androidx.compose.material3.Shapes(),
        content = content
    )
}
