package study.codingtest.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_9461 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<Integer, Long> map = new HashMap<>();
    map.put(1, 1L);
    map.put(2, 1L);
    map.put(3, 1L);
    map.put(4, 2L);
    map.put(5, 2L);

    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int n = Integer.parseInt(br.readLine());
      sb.append(sequence(map, n)).append("\n");
    }
    System.out.println(sb);
  }

  public static long sequence(Map<Integer, Long> map, int n) {
    if (!map.containsKey(n)) {
      map.put(n, sequence(map, n - 5) + sequence(map, n - 1));
    }
    return map.get(n);

  }

}
