fun rob(money: IntArray): Int {
  if (money.size == 1) {
      return money[0]
  }

  val dp = IntArray(money.size)
  dp[0][0] = 0
  dp[1][0] = 0
  dp[0][1] = 0
  dp[1][1] = money[1]

  for (i in 2 until money.size) {
      dp[0][i] = maxOf(dp[0][i - 1], dp[0][i - 2] + money[i])
      dp[1][i] = maxOf(dp[1][i - 1], dp[1][i - 2] + money[i])
  }

  return maxOf(money[0] + dp[0][money.size - 2], dp[1][money.size - 1])
}