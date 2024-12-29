package study.codingtest.leetcode;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC_743 {

  public int networkDelayTime(int[][] times, int n, int k) {
    Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    for (int[] time : times) {
      graph.putIfAbsent(time[0], new HashMap<>());
      graph.get(time[0]).put(time[1], time[2]);
    }

    Queue<Entry<Integer, Integer>> pq = new PriorityQueue<>(Entry.comparingByValue());
    pq.add(new SimpleEntry<>(k, 0));

    Map<Integer, Integer> dist = new HashMap<>();
    while (!pq.isEmpty()) {
      Entry<Integer, Integer> cur = pq.poll();
      int curK = cur.getKey();
      int curV = cur.getValue();
      if (!dist.containsKey(curK)) {
        dist.put(curK, curV);
        if (graph.containsKey(curK)) {
          graph.get(curK).forEach((key, value) -> pq.add(new SimpleEntry<>(key, curV + value)));
        }
      }
    }

    if (dist.size() == n) {
      return Collections.max(dist.values());
    }
    return -1;
  }
}
