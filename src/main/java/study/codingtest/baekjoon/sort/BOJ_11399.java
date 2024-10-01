package study.codingtest.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11399 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::valueOf)
        .sorted()
        .toArray();
    int[] result = new int[N];
    result[0] = arr[0];
    for (int i = 1; i < N; i++) {
      result[i] = result[i -1] + arr[i];
    }
    System.out.println(Arrays.stream(result).sum());
  }
}
