package study.codingtest.baekjoon.bps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class BOJ_2667 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int[][] directions = {
        new int[]{0, 1},
        new int[]{0, -1},
        new int[]{1, 0},
        new int[]{-1, 0}
    };

    int m = Integer.parseInt(br.readLine());
    int[][] map = new int[m][m];
    ArrayDeque<int[]> all = new ArrayDeque<>();
    Map<Integer, Set<Integer>> visited = new HashMap<>();

    for (int j = 0; j < m; j++) {
      map[j] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
      for (int i = 0; i < m; i++) {
        if (map[j][i] == 1) {
          all.offer(new int[]{j, i});
        }
      }
    }

    int count = 0;
    Queue<Integer> result = new PriorityQueue<>();
    while (!all.isEmpty()) {
      Queue<int[]> queue = new ArrayDeque<>();
      int[] start = all.poll();
      int subCount = 1;
      queue.offer(start);
      visited.putIfAbsent(start[0], new HashSet<>());
      visited.get(start[0]).add(start[1]);
      while (!queue.isEmpty()) {
        int[] cur = queue.poll();
        int[][] nextArray = Arrays.stream(directions)
            .map(d -> new int[]{cur[0] + d[0], cur[1] + d[1]})
            .filter(n -> n[0] >= 0 && n[0] < m && n[1] >= 0 && n[1] < m && map[n[0]][n[1]] == 1)
            .toArray(int[][]::new);

        for (int[] next : nextArray) {
          if (visited.containsKey(next[0]) && visited.get(next[0]).contains(next[1])) {
            continue;
          }
          all.removeIf(p -> p[0] == next[0] && p[1] == next[1]);
          queue.offer(next);
          visited.putIfAbsent(next[0], new HashSet<>());
          visited.get(next[0]).add(next[1]);
          subCount++;
        }
      }
      count++;
      result.add(subCount);
    }
    sb.append(count).append("\n");
    while (!result.isEmpty()) {
      sb.append(result.poll()).append("\n");
    }
    System.out.println(sb);
  }
}
