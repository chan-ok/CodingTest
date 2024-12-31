package study.codingtest.leetcode.greedy;

import java.util.Queue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC_406 {
  public int[][] reconstructQueue(int[][] people) {
    Queue<int[]> pq = new PriorityQueue<>(comp);

    for (int[] p : people) {
      pq.offer(p);
    }

    List<int[]> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      int[] person = pq.poll();
      result.add(person[1], person);
    }
    return result.toArray(new int[people.length][2]);
  }

  private Comparator<int[]> comp = (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1];
}
