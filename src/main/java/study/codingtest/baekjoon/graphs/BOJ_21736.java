package study.codingtest.baekjoon.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_21736 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    char[][] map = new char[N][M];
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int startX = 0;
    int startY = 0;
    for (int i = 0; i < N; i++) {
      map[i] = br.readLine().toCharArray();
      for (int j = 0; j < map[i].length; j++) {
        if (map[i][j] == 'I') {
          startY = i;
          startX = j;
        }
      }
    }
    Map<Integer, Set<Integer>> visited = new HashMap<>();
    visited.put(startY, new HashSet<>());
    visited.get(startY).add(startX);
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{startY, startX});
    int count = 0;

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      List<int[]> nexts = new ArrayList<>();
      for (int i = 0; i < 4; i++) {
        int nextY = cur[0] + dy[i];
        int nextX = cur[1] + dx[i];
        if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
          continue;
        }
        if (map[nextY][nextX] == 'X') {
          continue;
        }
        nexts.add(new int[]{nextY, nextX});
      }
      for (int[] next : nexts) {
        if (visited.containsKey(next[0]) && visited.get(next[0]).contains(next[1])) {
          continue;
        }
        if (map[next[0]][next[1]] == 'P') {
          count++;
        }
        visited.putIfAbsent(next[0], new HashSet<>());
        visited.get(next[0]).add(next[1]);
        queue.add(next);
      }
    }
    System.out.println(count > 0 ? count : "TT");
  }
}
