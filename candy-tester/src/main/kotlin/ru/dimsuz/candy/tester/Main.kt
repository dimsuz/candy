@file:Suppress("FunctionName")

package ru.dimsuz.candy.tester

import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.type
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.treesitter.TSParser
import org.treesitter.TSTree
import org.treesitter.TSTreeCursor
import org.treesitter.TreeSitterKotlin
import ru.dimsuz.candy.tester.uikit.AppTheme
import ru.dimsuz.candy.tester.uikit.ColorTheme
import ru.dimsuz.candy.tester.uikit.VSpacer

const val STARTING_SOURCE_CODE = """
              class Rectangle(val height: Double, val length: Double) {
                  val perimeter = (height + length) * 2 
              }
              
              fun main() {
                  val rectangle = Rectangle(5.0, 2.0)
                  println("The perimeter is ${'$'}{rectangle.perimeter}")
              }
            """

// TODO whenever edits are made, must inform the composition (add the parsed_at field?)
/**
 * A special wrapper class only to be able to mark stable, to reduce recompositions
 */
@Stable
@JvmInline
value class ParsedTree(
  val value: TSTree,
)

fun main() {
  val parser = TSParser()
  val kotlin = TreeSitterKotlin()
  parser.setLanguage(kotlin)

  val tree = ParsedTree(parser.parseString(null, STARTING_SOURCE_CODE))

  application {
    Window(
      onCloseRequest = ::exitApplication,
      title = "Candy Tester",
      state = rememberWindowState(
        position = WindowPosition(Alignment.Center),
        size = DpSize(1200.dp, 768.dp),
      ),
      onKeyEvent = { key ->
        if (key.type == KeyEventType.KeyDown && key.key == Key.Escape) {
          exitApplication()
          true
        } else false
      }
    ) {
      var sourceCode by remember { mutableStateOf(TextFieldValue(STARTING_SOURCE_CODE.trimIndent())) }
      AppTheme(ColorTheme.Light) {
        Row(
          modifier = Modifier.fillMaxSize()
        ) {
          SourceCode(
            modifier = Modifier
              .padding(8.dp)
              .weight(1f)
              .fillMaxHeight(),
            text = sourceCode,
            onChanged = { sourceCode = it }
          )
          Column(
            modifier = Modifier
              .padding(8.dp)
              .weight(1f)
              .fillMaxHeight()
          ) {
            Ast(
              modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f),
              tree = tree
            )
            VSpacer(8.dp)
            Box(
              modifier = Modifier
                .border(1.dp, AppTheme.colors.bgInvertPrimary)
                .weight(0.4f)
                .padding(4.dp)
            ) {
              var queryState by remember { mutableStateOf(TextFieldValue("Query")) }
              BasicTextField(
                modifier = Modifier.fillMaxSize(),
                value = queryState,
                onValueChange = { queryState = it }
              )
            }
          }
        }
      }
    }
  }
}

@Composable
private fun SourceCode(
  modifier: Modifier = Modifier,
  text: TextFieldValue,
  onChanged: (TextFieldValue) -> Unit
) {
  println("source code render")
  Box(
    modifier = modifier
      .border(1.dp, AppTheme.colors.bgInvertPrimary)
      .padding(4.dp)
      .verticalScroll(rememberScrollState())
  ) {
    BasicTextField(
      modifier = Modifier.matchParentSize(),
      value = text,
      onValueChange = onChanged
    )
  }
}

@Composable
private fun Ast(
  modifier: Modifier = Modifier,
  tree: ParsedTree,
) {
  println("ast render")
  val cursor = remember(tree) { TSTreeCursor(tree.value.rootNode) }
  cursor.reset(tree.value.rootNode)
  Column(
    modifier = modifier
  ) {
    Text(
      "Syntax Tree"
    )
    VSpacer(4.dp)
    // TODO make a LazyColumn?
    Box(
      modifier = Modifier
        .border(1.dp, AppTheme.colors.bgInvertPrimary)
        .padding(4.dp)
    ) {
      val scrollState = rememberScrollState()
      val scrollAdapter = rememberScrollbarAdapter(scrollState)
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .verticalScroll(scrollState)
      ) {
        var indentLevel = 0
        var retracing = false
        var rootReached = false
        while (!rootReached) {
          if (!retracing && cursor.currentNode().isNamed) {
            Text(
              modifier = Modifier.offset(24.dp * indentLevel),
              text = cursor.currentNode().type
            )
          }
          if (!retracing && cursor.gotoFirstChild()) {
            indentLevel += 1
            continue
          }

          if (cursor.gotoNextSibling()) {
            retracing = false
            continue
          }

          if (cursor.gotoParent()) {
            retracing = true
            indentLevel -= 1
          } else {
            rootReached = true
          }
        }
      }
      VerticalScrollbar(scrollAdapter, Modifier.align(Alignment.TopEnd))
    }
  }
}
