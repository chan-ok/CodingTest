package study.codingtest.baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11659 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
    int[] prefixSum = new int[N + 1];
    for (int i = 0; i < N; i++) {
      prefixSum[i + 1] = prefixSum[i] + arr[i];
    }
    for (int i = 0; i < M; i++) {
      int[] range = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
      System.out.println(prefixSum[range[1]] - prefixSum[range[0] - 1]);
    }
  }
}
