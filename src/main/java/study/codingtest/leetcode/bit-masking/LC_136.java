package study.codingtest.leetcode;

import java.util.Arrays;
import java.util.function.ToIntFunction;

public class LC_136 {
  public ToIntFunction<int[]> singleNumber = nums -> Arrays.stream(nums).reduce((a, b) -> a ^ b).orElse(0);
}
