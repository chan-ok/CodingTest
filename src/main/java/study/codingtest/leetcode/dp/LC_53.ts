const maxSubArray = (nums: number[]): number => {
  let curSum: number = 0;
  let maxSum: number = Number.MIN_SAFE_INTEGER;
  for (const num of nums) {
    curSum = Math.max(num, curSum + num);
    maxSum = Math.max(maxSum, curSum);
  }
  return maxSum;
};
