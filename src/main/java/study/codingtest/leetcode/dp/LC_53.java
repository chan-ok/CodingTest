package study.codingtest.leetcode.dp;

public class LC_53 {
  public int maxSubArray(int[] nums) {
    int currentSum = 0;
    int bestSum = Integer.MIN_VALUE;
    for (int num : nums) {
      currentSum = Math.max(num, currentSum + num);
      bestSum = Math.max(bestSum, currentSum);
    }
    return bestSum;
  }
}
