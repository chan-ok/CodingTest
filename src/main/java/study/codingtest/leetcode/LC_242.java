package study.codingtest.leetcode;

import java.util.Arrays;

public class LC_242 {

  public String sort(String s) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  public boolean isAnagram(String s, String t) {
    return sort(s).equals(sort(t));
  }
}
