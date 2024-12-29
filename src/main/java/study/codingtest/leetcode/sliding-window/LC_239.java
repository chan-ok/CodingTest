package study.codingtest.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC_239 {
  public int[] maxSlidingWindow(int[] nums, int k) {
    List<Integer> result = new ArrayList<>();
    Deque<Integer> dq = new ArrayDeque<>();

    for (int i = 0; i < nums.length; i++) {
      if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
        dq.pollFirst();
      }
      while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
        dq.pollLast();
      }
      dq.add(i);
      if (i >= k - 1) {
        result.add(nums[dq.peekFirst()]);
      }
    }
    return result.stream().mapToInt(i -> i).toArray();
  }
}
