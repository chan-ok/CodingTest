package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_12851 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    System.out.println(bfs(n, k));
  }

  public static String bfs(int n, int k) {
    if (n == k) {
      return "0\n1";
    }
    Map<Integer, Integer> discovered = new HashMap<>();
    discovered.put(n, 0);
    Queue<Integer> queue = new LinkedList<>();
    queue.add(n);
    int count = 0;
    int mininumPath = Integer.MAX_VALUE;
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      Set<Integer> set = new HashSet<>();
      if (discovered.getOrDefault(k, mininumPath) > discovered.get(cur)) {
        if (cur + 1 <= 100_000) {
          set.add(cur + 1);
        }
        if (cur - 1 >= 0) {
          set.add(cur - 1);
        }
        if (cur * 2 <= 100_000) {
          set.add(cur * 2);
        }
      }
      for (int next : set) {
        if (next == k) {
          count++;
        }
        if (discovered.containsKey(next)) {
          continue;
        }
        queue.add(next);
        discovered.put(next, discovered.get(cur) + 1);
      }
    }
    return discovered.containsKey(k) ? discovered.get(k) + "\n" + count : "-1";
  }
}
