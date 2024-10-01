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

public class BOJ_13913 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Map<Integer, Integer> result = bfs(n, k);
    int pointer = k;
    int count = 0;
    StringBuilder sb = new StringBuilder();
    sb.append(k);
    while (true) {
      if (pointer == n) {
        break;
      } else {
        count++;
        sb.insert(0, " ");
      }
      int prev = result.get(pointer);
      sb.insert(0, prev);
      pointer = prev;
    }
    System.out.println(count);
    System.out.println(sb);

  }

  public static Map<Integer, Integer> bfs(int n, int k) {
    Map<Integer, Integer> discovered = new HashMap<>();
    discovered.put(n, null);
    if (n == k) {
      return discovered;
    }
    Queue<Integer> queue = new LinkedList<>();
    queue.add(n);
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      List<Integer> list = new ArrayList<>();
      if (cur < 100_000) {
        list.add(cur + 1);
      }
      if (cur > 0) {
        list.add(cur - 1);
      }
      if (cur * 2 <= 100_000) {
        list.add(cur * 2);
      }
      for (int next : list) {
        if (discovered.containsKey(next)) {
          continue;
        }
        queue.add(next);
        discovered.put(next, cur);
        if (next == k) {
          return discovered;
        }
      }
    }
    return discovered;
  }
}
