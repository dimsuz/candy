package ru.dimsuz.candy.tester.uikit

import androidx.compose.ui.graphics.Color

// IMPORTANT: Do not ever make this "public"!
//
// feature screens and components and uikit components should never use palette colors directly,
// they should always work only with "AppColors".
// If your component has color which is absent from "AppColors", this means that designer made an error,
// you must contact designer team and ask them to use only "roles" (tokens) from uikit and never use "new" colors
// directly. If no corresponding role is present it must be created in UiKit by designers
// (but it's better to reuse some old one ideally)
//
// IMPORTANT: Do not ever make this "public"! See ^^^
internal object ColorPalette {
  val White = Color(0xFFFFFFFF)
  val White40 = Color(0x66FFFFFF)
  val White60 = Color(0x99FFFFFF)
  val Black = Color(0xFF000000)
  val Black50 = Color(0x80000000)
  val Black60 = Color(0x99000000)
  val Color01 = Color(0xFF999999)
  val Color02 = Color(0xFFDDDDDD)
  val Color03 = Color(0xFFF1F3F4)
  val Color04 = Color(0xFFF5EBFF)
  val Color05 = Color(0xFF9CFF60)
  val Color06 = Color(0xFF85FF3A)
  val Color07 = Color(0xFF75E331)
  val Color08 = Color(0xFF00FF85)
  val Color09 = Color(0xFFB9ECB8)
  val Color10 = Color(0xFFDBFFC3)
  val Color11 = Color(0xFFD7FDD6)
  val Color12 = Color(0xFFD9FFD2)
  val Color13 = Color(0xFFFF004D)
  val Color14 = Color(0xFFFF5F7C)
  val Color15 = Color(0xFFFFD600)
  val Color16 = Color(0xFFFFF738)
  val Color17 = Color(0xFFFFEE98)
  val Color18 = Color(0xFFFFF6C9)
  val Color19 = Color(0xFF0057FF)
  val Color20 = Color(0xFFE7EFFF)
  val Color21 = Color(0xFFD3E2FF)
  val Color22 = Color(0xFF8E1DFF)
  val Color23 = Color(0xFFFDCAD6)
  val Color24 = Color(0xFFFEE3E9)
  val Color25 = Color(0xFFFFE6EE)
  val Color26 = Color(0xFFECD9FF)
  val Color27 = Color(0xFF474747)
  val Color28 = Color(0xFFFFF6C9)
  val Color29 = Color(0xCC999999)
  val Color30 = Color(0xFFFFF738)
  val Color31 = Color(0xFF75E331)

  val ColorGradient10 = Color(0xFFEFEFEF)
  val ColorGradient11 = Color(0xFFF9F9F9)
}
