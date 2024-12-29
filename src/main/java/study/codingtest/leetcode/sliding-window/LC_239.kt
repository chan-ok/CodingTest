fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
  val result = mutableListOf<Int>()
  val dq = ArrayDeque<Int>()

  for (i in nums.indices) {
    if (dq.isNotEmpty() && dq.first() < i - k + 1) {
      dq.removeFirst()
    }
    while (dq.isNotEmpty() && nums[dq.last()] < nums[i]) {
      dq.removeLast()
    }
    dq.addLast(i)
    if (i >= k - 1) {
      result.add(nums[dq.first()])
    }
  }
  return result.toIntArray()
}