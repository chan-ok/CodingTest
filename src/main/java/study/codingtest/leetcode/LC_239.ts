const maxSlidingWindow = (nums: number[], k: number): number[] => {
  const result: number[] = [];
  const dq: number[] = [];

  for (let i = 0; i < nums.length; i++) {
    if (dq.length && dq[0] <= i - k) {
      dq.shift();
    }
    while (dq.length && nums[dq[dq.length - 1]] <= nums[i]) {
      dq.pop();
    }
    dq.push(i);
    if (i >= k - 1) {
      result.push(nums[dq[0]]);
    }
  }
  return result;
};
