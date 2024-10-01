package study.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11047 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    Queue<Integer> coins = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < N; i++) {
      int coin = Integer.parseInt(br.readLine());
      coins.offer(coin);
    }

    int count = 0;

    while (K != 0) {
      int coin = coins.poll();
      if (K < coin) {
        continue;
      }
      count += K / coin;
      K %= coin;
    }

    System.out.println(count);
  }
}
