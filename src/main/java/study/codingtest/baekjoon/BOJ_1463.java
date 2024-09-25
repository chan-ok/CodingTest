package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BOJ_1463 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());
    Map<Integer, Integer> memory = new HashMap<>();
    Queue<List<Integer>> queue = new LinkedList<>();
    queue.offer(List.of(x, 0));

    while (!queue.isEmpty()) {
      List<Integer> cur = queue.poll();

      if (cur.get(0) == 1) {
        System.out.println(cur.get(1));
        break;
      }

      if (memory.containsKey(cur.get(0))) {
        continue;
      }

      memory.put(cur.get(0), cur.get(1));
      if (cur.get(0) % 3 == 0) {
        int next = cur.get(0) / 3;
        queue.offer(List.of(next, cur.get(1) + 1));
      }
      if (cur.get(0) % 2 == 0) {
        int next = cur.get(0) / 2;
        queue.offer(List.of(next, cur.get(1) + 1));
      }
      int next = cur.get(0) - 1;
      queue.offer(List.of(next, cur.get(1) + 1));
    }
  }
}
