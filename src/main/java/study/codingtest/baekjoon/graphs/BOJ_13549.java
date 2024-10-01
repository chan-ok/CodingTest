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

public class BOJ_13549 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    System.out.println(bfs(n, k));
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
      for (int i = 0; i < list.size(); i++) {
        int currentStep = discovered.get(cur);
        int nextStep = cur * 2 == list.get(i) ? currentStep : currentStep + 1;
        if (discovered.containsKey(list.get(i)) && discovered.get(list.get(i)) <= nextStep) {
          continue;
        }
        queue.add(list.get(i));
        discovered.put(list.get(i), nextStep);
      }
    }
    return discovered.getOrDefault(k, -1);
  }
}
