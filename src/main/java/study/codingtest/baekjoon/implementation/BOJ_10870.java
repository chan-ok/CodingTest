package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10870 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    System.out.println(fibonachi(n));
    br.close();
  }

  public static int fibonachi(int n) {
    if (n < 2) {
      return n;
    }
    return fibonachi(n - 1) + fibonachi(n - 2);
  }

}
