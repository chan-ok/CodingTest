import java.util.*
import kotlin.collections.*

fun main(args: Array<String>) {

  val memo: MutableMap<String, SortedSet<Int>> = mutableMapOf()
  val sc: Scanner = Scanner(System.`in`)
  val expression: String = sc.nextLine()

  fun diffWaysToCompute(expression: String): SortedSet<Int> {
    if (memo.containsKey(expression)) {
      return memo[expression]!!
    }

    val result: SortedSet<Int> = sortedSetOf()
    for (i in expression.indices) {
      val c: Char = expression[i]
      if (c in "+-") {
        val left: SortedSet<Int> = diffWaysToCompute(expression.substring(0, i))
        val right: SortedSet<Int> = diffWaysToCompute(expression.substring(i + 1))

        when {
          c == '+' -> {
            result.add(left.first() + right.first())
            result.add(left.last() + right.last())
          }
          c == '-' -> {
            result.add(left.first() - right.last())
            result.add(left.last() - right.first())
          }
        }
      }
    }

    if (result.isEmpty()) {
      val value: Int = expression.toInt()
      result.add(value)
    }
    memo[expression] = result
    return result
  }

  val result: SortedSet<Int> = diffWaysToCompute(expression)
  println(result.first())
}