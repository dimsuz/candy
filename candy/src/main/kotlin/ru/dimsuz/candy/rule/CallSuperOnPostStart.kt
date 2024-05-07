package ru.dimsuz.candy.rule

import org.treesitter.TSParser
import org.treesitter.TSQuery
import org.treesitter.TSQueryCursor
import org.treesitter.TSQueryMatch
import org.treesitter.TreeSitterKotlin

class CallSuperOnPostStart {
  fun run() {
    val parser = TSParser()
    val kotlin = TreeSitterKotlin()
    parser.setLanguage(kotlin)
    val source = """
internal class RegularLoanModelImpl @Inject constructor() : ReactiveModel(), RegularLoanModel {
    private val stateFlow = MutableStateFlow(State())
    private lateinit var timer: Timer

    override fun onPostStart() {
      super.onPostStart()
      hello()
      timer = Timer(timerScope = scope)
    }
  }

    """.trimIndent()
    val tree = parser.parseString(null, source)

    val query = TSQuery(kotlin, """
      (class_body 
        (function_declaration
           (simple_identifier) @method_name
           (function_body
             (statements
               (call_expression)? @call
             )
           )
        )
      )
    """.trimIndent())
    val cursor = TSQueryCursor()
    cursor.exec(query, tree.rootNode)
    val match = TSQueryMatch()
    var n = 1
    while (cursor.nextMatch(match)) {
      match.captures.forEach { c ->
        val cap = source.toByteArray().sliceArray(c.node.startByte..c.node.endByte + 1).toString(Charsets.UTF_8)
        println("  capture ${c.index}: $cap")
      }
    }
  }
}
