package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10810 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    for (int i = 0; i < m; i++) {
      StringTokenizer round = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(round.nextToken()) - 1;
      int end = Integer.parseInt(round.nextToken());
      int ball = Integer.parseInt(round.nextToken());
      Arrays.fill(arr, start, end, ball);
    }
    StringBuilder sb = new StringBuilder();
    for (int j : arr) {
      sb.append(j).append(" ");
    }
    System.out.println(sb);
  }

}
