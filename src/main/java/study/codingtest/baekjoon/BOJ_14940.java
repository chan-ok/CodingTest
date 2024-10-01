package study.codingtest.baekjoon;

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

public class BOJ_14940 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int y = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());
    int[][] map = new int[y][x];
    int startX = 0;
    int startY = 0;

    for (int i = 0; i < y; i++) {
      map[i] = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::valueOf)
          .map(point -> point * -1)
          .toArray();
      for (int j = 0; j < x; j++) {
        if (map[i][j]== -2) {
          startY = i;
          startX = j;
        }
      }
    }

    Queue<List<Integer>> queue = new ArrayDeque<>();
    queue.offer(List.of(startY, startX));
    Map<Integer, Map<Integer, Integer>> visited = new HashMap<>();
    visited.put(startY, new HashMap<>());
    visited.get(startY).put(startX, 0);
    int[][] directions = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    while(!queue.isEmpty()) {
      List<Integer> cur = queue.poll();
      for (int[] direction : directions) {
        int nextY = cur.get(0) + direction[0];
        int nextX = cur.get(1) + direction[1];
        if (nextY >= 0 && nextY < y && nextX >= 0 && nextX < x && map[nextY][nextX] == -1) {
          if (visited.containsKey(nextY) && visited.get(nextY).containsKey(nextX)) {
            continue;
          }
          visited.putIfAbsent(nextY, new HashMap<>());
          visited.get(nextY).put(nextX, visited.get(cur.get(0)).get(cur.get(1)) + 1);
          queue.offer(List.of(nextY, nextX));
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < y; i++) {
      for (int j = 0; j < x; j++) {
        if(visited.containsKey(i) && visited.get(i).containsKey(j)) {
          sb.append(visited.get(i).get(j));
        } else {
          sb.append(map[i][j]);
        }
        sb.append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
