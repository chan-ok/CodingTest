package study.codingtest.baekjoon.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    System.out.println(bfs(n, k));
  }

  public static StringBuilder bfs(int n, int k) {
    int count = 0;
    StringBuilder sb = new StringBuilder();
    if (n == k) {
      return sb.append(0).append("\n").append(1);
    }
    Map<Integer, Integer> discovered = new HashMap<>();
    discovered.put(n, 0);
    Queue<List<Integer>> queue = new LinkedList<>();
    queue.add(List.of(n, 0));
    while (!queue.isEmpty()) {
      List<Integer> cur = queue.poll();
      List<List<Integer>> list = new ArrayList<>();
      if (cur.get(0) < 100_000) {
        list.add(List.of(cur.get(0) + 1, cur.get(1) + 1));
      }
      if (cur.get(0) > 0) {
        list.add(List.of(cur.get(0) - 1, cur.get(1) + 1));
      }
      if (cur.get(0) * 2 <= 100_000) {
        list.add(List.of(cur.get(0) * 2, cur.get(1) + 1));
      }
      for (List<Integer> next : list) {
        if (discovered.containsKey(next.get(0)) && next.get(1) > discovered.get(next.get(0))) {
          continue;
        }
        queue.add(next);
        discovered.put(next.get(0), discovered.get(cur.get(0)) + 1);
        if (next.get(0) == k) {
          count++;
        }
      }
    }
    return sb.append(discovered.get(k)).append("\n").append(count);
  }
}
