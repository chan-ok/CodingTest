package study.codingtest.baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int k = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    long[] arr = new long[k];
    for (int i = 0; i < k; i++) {
      arr[i] = Long.parseLong(br.readLine());
    }

    long result = binarySearch(arr, k, n);
    System.out.println(result);
  }

  private static long binarySearch(long[] arr, int k, int n) {
    long sum = 0;
    long left = 1;
    long right = Arrays.stream(arr).max().orElse(Long.MAX_VALUE);
    long mid = (left + right) / 2;

    while (left + 1 < right) {
      for (int i = 0; i < k; i++) {
        sum += arr[i] / mid;
      }
      if (sum >= n) {
        left = Math.max(left, mid);
        mid = (right + mid) / 2;
      } else {
        right = Math.min(right, mid);
        mid = (left + mid) / 2;
      }
      sum = 0;
    }

    for (int i = 0; i < k; i++) {
      sum += arr[i] / right;
    }
    if (sum >= n) {
      return right;
    }
    sum = 0;
    for (int i = 0; i < k; i++) {
      sum += arr[i] / mid;
    }
    return sum >= n ? mid : 0;
  }
}
