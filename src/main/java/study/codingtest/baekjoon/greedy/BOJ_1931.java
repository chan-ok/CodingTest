package study.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1931 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Queue<Integer[]> queue = new PriorityQueue<>(
        (q1, q2) -> !q1[1].equals(q2[1]) ? q1[1] - q2[1] : q1[0] - q2[0]);
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      Integer[] arr = Arrays.stream(br.readLine().split(" "))
          .map(Integer::valueOf)
          .toArray(Integer[]::new);
      queue.offer(arr);
    }

    int count = 0, end = 0;
    while (!queue.isEmpty()) {
      Integer[] cur = queue.poll();
      if (cur[0] >= end && cur[1] >= end) {
        end = cur[1];
        count++;
      }
    }
    System.out.println(count);
  }
}
