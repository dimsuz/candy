package ru.dimsuz.candy.tester.uikit

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColors(
  val isLight: Boolean,

  val bgPrimary: Color,
  val bgInvertPrimary: Color,

  val textPrimary: Color,
  val textSecondary: Color,
  val textDisabled: Color,
  val textNegative: Color,
  val textInvertPrimary: Color,
  val textInvertSecondary: Color,
  val textInvertDisabled: Color,
  val textWarning: Color,
  val textAccentBrand: Color,

  val surfacePrimary: Color,
  val surfaceAccentBrand: Color,
  val surfaceAccentSecondary: Color,
  val surfaceAccentContainer: Color,
  val surfaceNegative: Color,
  val surfaceNegativeContainer: Color,
  val surfaceNotify: Color,
  val surfaceOpacity: Color,
  val surfaceSkeleton: List<Color>,

  val iconPrimary: Color,
  val iconDisabled: Color,
  val iconAccentBrand: Color,
  val iconInvertPrimary: Color,
  val iconInvertDisabled: Color,
  val iconWarning: Color,

  val buttonAccent: Color,
  val buttonAccentPress: Color,
  val buttonAccentDisabled: Color,
  val buttonSecondary: Color,
  val buttonSecondaryPress: Color,
  val buttonInvertPrimary: Color,
  val buttonPrimaryBlack: Color,
  val buttonPrimaryBlackPress: Color,
  val buttonOpacityPress: Color,

  val stateOverlay: Color,
  val stateNavbar: Color,
)
