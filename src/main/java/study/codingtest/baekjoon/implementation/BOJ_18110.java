package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_18110 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    Queue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      pq.offer(Integer.parseInt(br.readLine()));
    }

    long cutLine = Math.round(pq.size() * 0.15);
    double realData = n - 2 * cutLine;
    long sum = 0;
    for (int i = 0; i < cutLine; i++) {
      pq.poll();
    }
    for (int i = 0; i < realData; i++) {
      sum += pq.poll();
    }
    System.out.println(Math.round(sum / realData));
  }

}
