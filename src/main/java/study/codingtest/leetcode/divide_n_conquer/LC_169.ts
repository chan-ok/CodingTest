const majorityElement = (nums: number[]): number => {
  const majorityElement = (nums: number[], lo: number, hi: number): number => {
    if (lo === hi) {
      return nums[lo];
    }

    const mid = lo + Math.floor((hi - lo) / 2);
    const left = majorityElement(nums, lo, mid);
    const right = majorityElement(nums, mid + 1, hi);

    let countA = 0;
    for (let i = lo; i <= hi; i++) {
      if (nums[i] === left) {
        countA++;
      }
    }
    return countA > (hi - lo + 1) / 2 ? left : right;
  };

  return majorityElement(nums, 0, nums.length - 1);
};
