package com.example.yphone.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFFC67D), // Coral80
    secondary = Color(0xFF1ABC9C), // Turquoise80
    tertiary = Color(0xFFC7B8EA), // Lavender80
    background = Color(0xFF1A1A2E),
    surface = Color(0xFF16213E),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFFE8E8E8),
    onSurface = Color(0xFFE8E8E8)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFFF69B4), // VibrantPink
    secondary = Color(0xFFFFA07A), // VibrantOrange
    tertiary = Color(0xFF7A288A), // VibrantPurple
    background = Color(0xFFFFF8DC), // Cornsilk background for warmth
    surface = Color(0xFFF0F8FF), // Alice blue for surfaces
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF2F2F2F),
    onSurface = Color(0xFF2F2F2F),
    surfaceVariant = Color(0xFFE6F3FF),
    outline = Color(0xFF0000FF) // VibrantBlue
)

@Composable
fun YPhoneTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}