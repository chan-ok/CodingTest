package study.codingtest.baekjoon.bps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_7569 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int z = Integer.parseInt(st.nextToken());
    int[][][] box = new int[z][m][n];
    int count = 0;
    Queue<Integer[]> q = new ArrayDeque<>();
    Map<Integer, Map<Integer, Map<Integer, Integer>>> visited = new HashMap<>();

    for (int h = 0; h < z; h++) {
      for (int y = 0; y < m; y++) {
        box[h][y] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        for (int x = 0; x < n; x++) {
          if (box[h][y][x] == 0) {
            count++;
          } else if (box[h][y][x] == 1) {
            Integer[] point = new Integer[]{h, y, x};
            q.offer(point);
            visited.putIfAbsent(h, new HashMap<>());
            visited.get(h).putIfAbsent(y, new HashMap<>());
            visited.get(h).get(y).put(x, 0);
          }
        }
      }
    }

    int[][] directions = {
        {1, 0, 0},
        {-1, 0, 0},
        {0, 1, 0},
        {0, -1, 0},
        {0, 0, 1},
        {0, 0, -1}
    };

    while (!q.isEmpty()) {
      Integer[] cur = q.poll();

      List<Integer[]> nextList = Arrays.stream(directions)
          .map(d -> new Integer[]{cur[0] + d[0], cur[1] + d[1], cur[2] + d[2]})
          .filter(p -> p[0] >= 0 && p[0] < z
              && p[1] >= 0 && p[1] < m
              && p[2] >= 0 && p[2] < n
              && box[p[0]][p[1]][p[2]] == 0)
          .collect(Collectors.toList());

      for (Integer[] next : nextList) {
        if (visited.containsKey(next[0])
            && visited.get(next[0]).containsKey(next[1])
            && visited.get(next[0]).get(next[1]).containsKey(next[2])) {
          continue;
        }
        visited.putIfAbsent(next[0], new HashMap<>());
        visited.get(next[0]).putIfAbsent(next[1], new HashMap<>());
        visited.get(next[0]).get(next[1])
            .put(next[2], visited.get(cur[0]).get(cur[1]).get(cur[2]) + 1);
        q.offer(next);
        count--;
      }
    }
    if (count > 0) {
      System.out.println(-1);
    } else {
      int max = visited.values().stream()
          .flatMap(map -> map.values().stream())
          .flatMapToInt(map -> map.values().stream().mapToInt(Integer::valueOf))
          .max()
          .getAsInt();
      System.out.println(max);
    }
  }
}
