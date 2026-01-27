package com.patidost.app.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    primaryContainer = PrimaryVariantColor,
    secondary = SecondaryColor,
    secondaryContainer = SecondaryVariantColor,
    surface = SurfaceColor,
    background = BackgroundColor,
    error = ErrorColor,
    onPrimary = TextOnPrimary,
    onSecondary = TextOnSecondary,
    onSurface = TextPrimary,
    onBackground = TextPrimary,
    onError = TextOnPrimary
)

private val DarkColorScheme = darkColorScheme(
    primary = Blue10,
    primaryContainer = Blue40,
    secondary = Green10,
    secondaryContainer = Green40,
    surface = Neutral80,
    background = Neutral90,
    error = ErrorColor,
    onPrimary = Neutral90,
    onSecondary = Neutral90,
    onSurface = Neutral10,
    onBackground = Neutral10,
    onError = Neutral10
)

@Composable
fun PatiDostTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    
    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}
