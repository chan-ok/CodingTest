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

public class BOJ_7576 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] box = new int[m][n];
    int count = 0;
    Queue<Integer[]> tomato = new ArrayDeque<>();
    Map<Integer, Map<Integer, Integer>> visited = new HashMap<>();

    for (int i = 0; i < m; i++) {
      box[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
      for (int j = 0; j < box[i].length; j++) {
        if (box[i][j] == 0) {
          count++;
        } else if (box[i][j] == 1) {
          Integer[] point = new Integer[]{i, j};
          tomato.offer(point);
          visited.putIfAbsent(i, new HashMap<>());
          visited.get(i).put(j, 0);
        }
      }
    }

    int[][] directions = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    while (!tomato.isEmpty()) {
      Integer[] cur = tomato.poll();

      List<Integer[]> nexts = Arrays.stream(directions)
          .map(d -> new Integer[]{cur[0] + d[0], cur[1] + d[1]})
          .filter(p -> p[0] >= 0 && p[0] < box.length
              && p[1] >= 0 && p[1] < box[0].length
              && box[p[0]][p[1]] == 0)
          .collect(Collectors.toList());

      for (Integer[] next : nexts) {
        if (visited.containsKey(next[0]) && visited.get(next[0]).containsKey(next[1])) {
          continue;
        }
        visited.putIfAbsent(next[0], new HashMap<>());
        visited.get(next[0]).put(next[1], visited.get(cur[0]).get(cur[1]) + 1);
        tomato.offer(next);
        count--;
      }
    }
    if (count > 0) {
      System.out.println(-1);
    } else {
      int max = visited.values().stream()
          .flatMapToInt(entry -> entry.values().stream()
              .mapToInt(Integer::valueOf))
          .max()
          .getAsInt();
      System.out.println(max);
    }
  }
}
