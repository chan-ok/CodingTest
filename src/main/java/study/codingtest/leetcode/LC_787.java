package study.codingtest.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC_787 {

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    for (int[] flight : flights) {
      graph.putIfAbsent(flight[0], new HashMap<>());
      graph.get(flight[0]).put(flight[1], flight[2]);
    }

    Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
    pq.add(Arrays.asList(src, 0, 0));

    Map<Integer, Integer> visited = new HashMap<>();

    while (!pq.isEmpty()) {
      List<Integer> cur = pq.poll();
      int u = cur.get(0);
      int price_u = cur.get(1);
      int k_visited = cur.get(2);
      if (u == dst) {
        return price_u;
      }
      visited.put(u, k_visited);

      if (k_visited <= k) {
        k_visited += 1;
        if (graph.containsKey(u)) {
          for (Entry<Integer, Integer> v : graph.get(u).entrySet()) {
            if (!visited.containsKey(v.getKey()) || k_visited < visited.get(v.getKey())) {
              pq.add(Arrays.asList(v.getKey(), price_u + v.getValue(), k_visited));
            }
          }
        }
      }
    }
    return -1;
  }
}
