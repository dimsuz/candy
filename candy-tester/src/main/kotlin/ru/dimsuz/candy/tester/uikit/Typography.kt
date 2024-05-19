package ru.dimsuz.candy.tester.uikit

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

private val Roboto = FontFamily(
  Font("fonts/roboto_regular.ttf", FontWeight.Normal, FontStyle.Normal),
  Font("fonts/roboto_medium.ttf", FontWeight.Normal, FontStyle.Normal),
  Font("fonts/roboto_bold.ttf", FontWeight.Normal, FontStyle.Normal),
)

@Immutable
data class AppTypography internal constructor(
  val h1: TextStyle = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.Bold,
    fontSize = 34.sp,
    lineHeight = 42.sp,
  ),
  val h2: TextStyle = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.Bold,
    fontSize = 22.sp,
    lineHeight = 30.sp,
  ),
  val title1: TextStyle = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.Bold,
    fontSize = 17.sp,
    lineHeight = 22.sp,
  ),
  val title2: TextStyle = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.Bold,
    fontSize = 17.sp,
    lineHeight = 20.sp,
  ),
  val title3: TextStyle = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.Medium,
    fontSize = 15.sp,
    lineHeight = 20.sp,
  ),
  val body1: TextStyle = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.Normal,
    fontSize = 17.sp,
    lineHeight = 22.sp,
  ),
  val body2: TextStyle = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.Normal,
    fontSize = 15.sp,
    lineHeight = 20.sp,
  ),
  val caption1: TextStyle = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.Bold,
    fontSize = 13.sp,
    lineHeight = TextUnit.Unspecified,
  ),
  val caption2: TextStyle = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.Normal,
    fontSize = 13.sp,
    lineHeight = TextUnit.Unspecified,
  ),
  val caption3: TextStyle = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.Medium,
    fontSize = 10.sp,
    lineHeight = TextUnit.Unspecified,
  ),
  val fontone: TextStyle = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 16.sp,
  ),
  val button: TextStyle = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.Medium,
    fontSize = 15.sp,
    lineHeight = TextUnit.Unspecified,
  )
)

internal val LocalAppTypography = staticCompositionLocalOf { AppTypography() }
