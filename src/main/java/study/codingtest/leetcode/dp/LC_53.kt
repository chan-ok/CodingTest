fun maxSubArray(nums: IntArray): Int {
  var curSum: Int = 0;
  var maxSum: Int = Int.MIN_VALUE;
  for (num in nums) {
    curSum = Math.max(num, curSum + num);
    maxSum = Math.max(maxSum, curSum);
  }
  return maxSum;
}