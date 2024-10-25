package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_26645 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int result = 1;
    if (n >= 206) {
      result = 2;
    }
    if (n >= 218) {
      result = 3;
    }
    if (n >= 229) {
      result = 4;
    }
    System.out.println(result);
  }

}
