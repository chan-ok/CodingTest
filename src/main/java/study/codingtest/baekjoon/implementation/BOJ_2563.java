package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2563 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] paper = new int[100][100];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      for (int sy = y; sy < y + 10; sy++) {
        for (int sx = x; sx < x + 10; sx++) {
          paper[sy][sx] = 1;
        }
      }
    }
    int sum = Arrays.stream(paper).flatMapToInt(Arrays::stream).sum();
    System.out.println(sum);
  }
}
