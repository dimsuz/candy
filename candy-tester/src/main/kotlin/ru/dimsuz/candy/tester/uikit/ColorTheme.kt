package ru.dimsuz.candy.tester.uikit

import androidx.compose.runtime.staticCompositionLocalOf

enum class ColorTheme {
  Light, Dark
}

internal val LightColors = AppColors(
  isLight = true,

  bgPrimary = ColorPalette.White,
  bgInvertPrimary = ColorPalette.Black,

  textPrimary = ColorPalette.Black,
  textSecondary = ColorPalette.Color01,
  textDisabled = ColorPalette.Color01,
  textNegative = ColorPalette.Color14,
  textInvertPrimary = ColorPalette.White,
  textInvertSecondary = ColorPalette.White60,
  textInvertDisabled = ColorPalette.White40,
  textWarning = ColorPalette.Color30,
  textAccentBrand = ColorPalette.Color31,

  surfacePrimary = ColorPalette.Color03,
  surfaceAccentBrand = ColorPalette.Color05,
  surfaceAccentSecondary = ColorPalette.Color28,
  surfaceAccentContainer = ColorPalette.Color12,
  surfaceNegative = ColorPalette.Color14,
  surfaceNegativeContainer = ColorPalette.Color25,
  surfaceNotify = ColorPalette.Color16,
  surfaceOpacity = ColorPalette.Black60,
  surfaceSkeleton = listOf(ColorPalette.ColorGradient10, ColorPalette.ColorGradient11),

  iconPrimary = ColorPalette.Black,
  iconDisabled = ColorPalette.Color01,
  iconAccentBrand = ColorPalette.Color07,
  iconInvertPrimary = ColorPalette.White,
  iconInvertDisabled = ColorPalette.White40,
  iconWarning = ColorPalette.Color30,

  buttonAccent = ColorPalette.Color05,
  buttonAccentPress = ColorPalette.Color06,
  buttonAccentDisabled = ColorPalette.Color10,
  buttonSecondary = ColorPalette.Color03,
  buttonSecondaryPress = ColorPalette.Color02,
  buttonInvertPrimary = ColorPalette.White40,
  buttonPrimaryBlack = ColorPalette.Black,
  buttonPrimaryBlackPress = ColorPalette.Color27,
  buttonOpacityPress = ColorPalette.Color29,

  stateOverlay = ColorPalette.Black50,
  stateNavbar = ColorPalette.White,
)

internal val DarkColors = LightColors

internal val LocalAppColors = staticCompositionLocalOf<AppColors> {
  error("No AppColors provided")
}

internal val LocalColorTheme = staticCompositionLocalOf<ColorTheme> {
  error("No ColorTheme provided")
}
