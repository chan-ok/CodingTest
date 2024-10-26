package study.codingtest.leetcode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LC_179 {

  public String largestNumber(int[] nums) {
    int i = 1;
    while (i < nums.length) {
      int j = i;
      while (j > 0 && toSwap(nums[j - 1], nums[j])) {
        int temp = nums[j];
        nums[j] = nums[j - 1];
        nums[j - 1] = temp;
        j--;
      }
      i++;
    }

    if (nums[0] == 0) {
      return "0";
    } else {
      return Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining());
    }
  }

  public boolean toSwap(int n1, int n2) {
    return
        new BigInteger(String.valueOf(n1) + n2).compareTo(new BigInteger(String.valueOf(n2) + n1))
            > 0;
  }

}
