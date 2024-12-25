package study.codingtest.leetcode;

public class LC_461 {
  public int hammingDistance(int x, int y) {
    int xor = x ^ y;
    return Integer.bitCount(xor);
}
}
