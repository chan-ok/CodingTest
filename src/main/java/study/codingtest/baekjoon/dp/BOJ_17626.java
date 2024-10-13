package study.codingtest.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17626 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int min = Integer.MAX_VALUE;
    for (int i = (int) Math.sqrt(n); i > 0; i--) {
      int n1 = n - i * i;
      if (n1 == 0) {
        System.out.println(1);
        return;
      }
      for (int j = (int) Math.sqrt(n1); j > 0; j--) {
        int n2 = n - i * i - j * j;
        if (n2 == 0) {
          System.out.println(2);
          return;
        }
        for (int k = (int) Math.sqrt(n2); k > 0; k--) {
          int n3 = n - i * i - j * j - k * k;
          if (n3 == 0) {
            min = 3;
            break;
          } else if (min != 3) {
            int l = (int) Math.sqrt(n3);
            int n4 = n - i * i - j * j - k * k - l * l;
            if (n4 == 0) {
              min = 4;
            }
          }
        }
      }
    }
    System.out.println(min);
  }
}
