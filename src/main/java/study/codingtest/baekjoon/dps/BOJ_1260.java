package study.codingtest.baekjoon.dps;

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
import java.util.TreeSet;

public class BOJ_1260 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int vertex = Integer.parseInt(st.nextToken());
    int line = Integer.parseInt(st.nextToken());
    int start = Integer.parseInt(st.nextToken());
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int i = 1; i <= vertex; i++) {
      graph.put(i, new TreeSet<>());
    }
    for (int i = 0; i < line; i++) {
      StringTokenizer vv = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(vv.nextToken());
      int v2 = Integer.parseInt(vv.nextToken());
      graph.get(v1).add(v2);
      graph.get(v2).add(v1);
    }

    Set<Integer> dfsVisited = new HashSet<>();
    dfsVisited.add(start);
    List<Integer> dfsResult = new ArrayList<>();
    dfsResult.add(start);
    dfs(dfsVisited, dfsResult, graph, start, vertex);
    StringBuilder sb = new StringBuilder();
    for (int i : dfsResult) {
      sb.append(i).append(" ");
    }
    System.out.println(sb);

    Set<Integer> bfsVisited = new HashSet<>();
    bfsVisited.add(start);
    List<Integer> bfsResult = new ArrayList<>();
    bfsResult.add(start);
    bfs(bfsVisited, bfsResult, graph, start);
    sb = new StringBuilder();
    for (int i : bfsResult) {
      sb.append(i).append(" ");
    }
    System.out.println(sb);
  }

  public static void dfs(Set<Integer> visited, List<Integer> list,
      Map<Integer, Set<Integer>> map, int cur, int vertex) {
    if (vertex == list.size()) {
      return;
    }
    for (int next : map.get(cur)) {
      if (visited.contains(next)) {
        continue;
      }
      list.add(next);
      visited.add(next);
      dfs(visited, list, map, next, vertex);
    }
  }

  public static void bfs(Set<Integer> visited, List<Integer> list, Map<Integer, Set<Integer>> map,
      int start) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(start);
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for (int next : map.get(cur)) {
        if (visited.contains(next)) {
          continue;
        }
        list.add(next);
        visited.add(next);
        queue.offer(next);
      }
    }
  }
}
