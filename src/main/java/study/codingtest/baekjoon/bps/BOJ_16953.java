package study.codingtest.baekjoon.bps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());
    Map<Integer, Integer> visited = new HashMap<>();
    visited.put(start, 1);
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(start);

    while (!q.isEmpty()) {
      int cur = q.poll();
      List<Integer> next = new ArrayList<>();
      if (cur * 2L < Integer.MAX_VALUE) {
        next.add(cur * 2);
      }
      if (Long.parseLong(cur + "1") < Integer.MAX_VALUE) {
        next.add(Integer.parseInt(cur + "1"));
      }
      for (int n : next) {
        if (visited.containsKey(n)) {
          continue;
        }
        visited.put(n, visited.get(cur) + 1);
        q.offer(n);
        if (n == end) {
          break;
        }
      }
    }
    System.out.println(visited.getOrDefault(end, -1));
  }
}
