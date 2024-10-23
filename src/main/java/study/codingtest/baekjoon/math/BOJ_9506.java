package study.codingtest.baekjoon.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9506 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while(true) {
      int n = Integer.parseInt(br.readLine());
      if (n == -1) {
        break;
      }
      int sum = 1;
      StringBuilder sb = new StringBuilder();
      sb.append(n).append(" = 1");
      for (int i = 2; i <= n / 2; i++) {
        if (n % i == 0) {
          sum += i;
          sb.append(" + ").append(i);
        }
      }
      if (sum == n) {
        System.out.println(sb);
      } else {
        System.out.println(n + " is NOT perfect.");
      }
    }
  }

}
