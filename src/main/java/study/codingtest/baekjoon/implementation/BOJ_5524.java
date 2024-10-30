package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_5524 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      System.out.println(br.readLine().toLowerCase());
    }
  }

}
