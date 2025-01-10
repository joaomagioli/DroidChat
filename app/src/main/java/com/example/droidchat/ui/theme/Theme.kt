package com.example.droidchat.ui.theme

import ColorError
import Green20
import Green40
import Green80
import Neutral10
import Neutral60
import Neutral90
import Surface
import Turqouise10
import Turqouise90
import Turquoise30
import Turquoise80
import Wildfire20
import Wildfire80
import Wildfire90
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
    primary = Turquoise80,
    onPrimary = Color.White,
    primaryContainer = Turquoise30,
    onPrimaryContainer = Turqouise90,
    secondary = Green80,
    onSecondary = Green20,
    tertiary = Wildfire80,
    onTertiary = Wildfire20,
    surface = Neutral10,
    onSurface = Neutral90,
    onSurfaceVariant = Neutral60,
    inverseSurface = Color.White,
    inverseOnSurface = Color.Black,
    error = ColorError,
)

private val LightColorScheme = lightColorScheme(
    primary = Turquoise80,
    onPrimary = Color.White,
    primaryContainer = Turqouise90,
    onPrimaryContainer = Turqouise10,
    secondary = Green40,
    onSecondary = Color.Black,
    tertiary = Wildfire90,
    onTertiary = Color.Black,
    surface = Surface,
    onSurface = Neutral10,
    onSurfaceVariant = Neutral60,
    inverseSurface = Color.Black,
    inverseOnSurface = Color.White,
    error = ColorError,
)

@Composable
fun DroidChatTheme(
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