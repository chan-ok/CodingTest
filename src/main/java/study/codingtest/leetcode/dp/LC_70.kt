val dp = IntArray(46)

fun climbStairs(n: Int): Int {
  when {
    n <= 2 -> return n
    dp[n] != 0 -> return dp[n]
    else -> {
      dp[n] = climbStairs(n - 1) + climbStairs(n - 2)
      return dp[n]
    }
  }
}
