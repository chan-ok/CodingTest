package study.codingtest.baekjoon.divide_n_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BOJ_2630 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] paper = new int[n][n];
    for (int i = 0; i < n; i++) {
      paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
    }
    Map<Integer, Integer> count = new HashMap<>();
    countPaper(count, n, paper);
    System.out.println(count.getOrDefault(0, 0));
    System.out.println(count.getOrDefault(1, 0));
  }

  public static Map<Integer, Integer> countPaper(Map<Integer, Integer> count, int size,
      int[][] paper) {
    int sum = 0;
    for (int i = 0; i < size; i++) {
      sum += Arrays.stream(paper[i]).sum();
    }
    if (sum == size * size) {
      count.put(1, count.getOrDefault(1, 0) + 1);
    } else if (sum == 0) {
      count.put(0, count.getOrDefault(0, 0) + 1);
    } else {
      int nextSize = size / 2;
      countPaper(count, nextSize, cutPaper(paper, 0, 0));
      countPaper(count, nextSize, cutPaper(paper, nextSize, 0));
      countPaper(count, nextSize, cutPaper(paper, 0, nextSize));
      countPaper(count, nextSize, cutPaper(paper, nextSize, nextSize));
    }
    return count;
  }

  public static int[][] cutPaper(int[][] paper, int x, int y) {
    int size = paper.length / 2;
    int[][] newPaper = new int[size][size];
    for (int i = 0; i < size; i++) {
      newPaper[i] = Arrays.copyOfRange(paper[i + y], x, x + size);
    }
    return newPaper;
  }
}
