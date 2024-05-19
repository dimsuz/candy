package ru.dimsuz.candy.tester.uikit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.material.ripple.RippleTheme as MaterialRippleTheme

@Immutable
object RippleTheme : MaterialRippleTheme {
  @Composable
  override fun defaultColor() = MaterialRippleTheme.defaultRippleColor(
    contentColor = AppTheme.colors.stateOverlay,
    lightTheme = AppTheme.colors.isLight
  )

  @Composable
  override fun rippleAlpha() = MaterialRippleTheme.defaultRippleAlpha(
    contentColor = AppTheme.colors.stateOverlay,
    lightTheme = AppTheme.colors.isLight
  )
}
