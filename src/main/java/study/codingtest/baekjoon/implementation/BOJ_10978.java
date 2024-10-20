package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10978 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int y = 5, x = 15, max = 0;
    char[][] arr = new char[y][x];
    for (int i = 0; i < y; i++) {
      char[] line = br.readLine().toCharArray();
      max = Math.max(max, line.length);
      arr[i] = Arrays.copyOf(line, x);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < max; i++) {
      for (int j = 0; j < y; j++) {
        if (arr[j][i] > 0) {
          sb.append(arr[j][i]);
        }
      }
    }
    System.out.println(sb);
  }

}
