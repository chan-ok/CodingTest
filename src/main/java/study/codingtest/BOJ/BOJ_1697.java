package study.codingtest.BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
      StringTokenizer st = new StringTokenizer(reader.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      writer.write(String.valueOf(bfs(n, k)));
      writer.flush();
    }
  }

  public static int bfs(int n, int k) {
    if (n == k) {
      return 0;
    }
    Map<Integer, Integer> discovered = new HashMap<>();
    discovered.put(n, 0);
    Queue<Integer> queue = new LinkedList<>();
    queue.add(n);
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      List<Integer> list = new ArrayList<>();
      if (cur + 1 <= 100_000) {
        list.add(cur + 1);
      }
      if (cur - 1 >= 0) {
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
        discovered.put(next, discovered.get(cur) + 1);
        if (next == k) {
          return discovered.get(next);
        }
      }
    }
    return -1;
  }
}
