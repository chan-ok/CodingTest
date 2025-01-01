package study.codingtest.leetcode.dp;

public class LC_509 {
  public int fib(int n) {
    int x = 0, y = 1;
    for (int i = 0; i < n; i++) {
      int sum = x + y;
      x = y;
      y = sum;
    }
    return x;
  }
}