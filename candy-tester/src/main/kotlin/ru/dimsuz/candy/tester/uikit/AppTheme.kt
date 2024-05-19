package ru.dimsuz.candy.tester.uikit

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.LocalContentColor
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

object AppTheme {
  val colors: AppColors
    @Composable
    @ReadOnlyComposable
    get() = LocalAppColors.current

  val typography: AppTypography
    @Composable
    @ReadOnlyComposable
    get() = LocalAppTypography.current

  val shapes: AppShapes = AppShapes
}

@Composable
fun AppTheme(
  currentTheme: ColorTheme,
  content: @Composable () -> Unit
) {
  val colors = remember(currentTheme) {
    when (currentTheme) {
      ColorTheme.Light -> LightColors
      ColorTheme.Dark -> DarkColors
    }
  }

  val textSelectionColors = TextSelectionColors(
    handleColor = colors.textPrimary,
    backgroundColor = colors.textAccentBrand.copy(alpha = 0.4f)
  )
  val rippleIndication = rememberRipple()
  CompositionLocalProvider(
    LocalAppColors provides colors,
    LocalColorTheme provides currentTheme,
    LocalAppTypography provides AppTheme.typography,
    LocalContentColor provides colors.textPrimary,
    LocalTextSelectionColors provides textSelectionColors,
    LocalIndication provides rippleIndication,
    LocalRippleTheme provides RippleTheme,
    content = content
  )
}
