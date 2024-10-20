package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2566 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] p = new int[2];
    int max = 0;
    for (int i = 0; i < 9; i++) {
      int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf)
          .toArray();
      for (int j = 0; j < 9; j++) {
        if (max < line[j]) {
          max = line[j];
          p[0] = i;
          p[1] = j;
        }
      }
    }
    System.out.println(max);
    System.out.println((p[0] + 1) + " " + (p[1] + 1));
  }

}
