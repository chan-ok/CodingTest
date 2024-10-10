package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2749 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    int p = 15_000_000;
    int a = (int) (n % p);
    int[] fibo = new int[p];
    fibo[0] = 0;
    fibo[1] = 1;
    for (int i = 2; i < p; i++) {
      fibo[i] = fibo[i - 1] + fibo[i - 2];
      fibo[i] %= 1_000_000;
    }
    System.out.println(fibo[a]);
  }
}
