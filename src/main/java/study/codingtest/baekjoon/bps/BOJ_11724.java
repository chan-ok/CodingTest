package study.codingtest.baekjoon.bps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_11724 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    for (int i = 1; i <= n; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      StringTokenizer uv = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(uv.nextToken());
      int v = Integer.parseInt(uv.nextToken());
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    int count = 0;
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      if (visited.contains(i)) {
        continue;
      }
      queue.offer(i);
      while (!queue.isEmpty()) {
        int cur = queue.poll();
        List<Integer> nextList = graph.get(cur);
        for (int next : nextList) {
          if (visited.contains(next)) {
            continue;
          }
          visited.add(next);
          queue.offer(next);
        }
      }
      count++;
    }
    System.out.println(count);
  }
}
