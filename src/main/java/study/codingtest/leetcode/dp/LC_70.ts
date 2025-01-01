const dp = new Array(46).fill(0);

const climbStairs = (n: number): number => {
  if (n <= 2) return n;
  if (dp[n] !== 0) return dp[n];
  dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
  return dp[n];
};
