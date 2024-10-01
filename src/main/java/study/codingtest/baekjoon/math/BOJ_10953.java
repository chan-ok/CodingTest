package study.codingtest.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10953 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      int sum = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::valueOf).sum();
      System.out.println(sum);
    }
  }
}
