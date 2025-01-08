package study.codingtest.baekjoon.bps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_31863 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] sp = new int[2];
    Queue<int[]> queue = new LinkedList<>();
    Map<Integer, Integer> buildingCount = new HashMap<>();
    buildingCount.put(0, 0);
    buildingCount.put(1, 0);

    char[][] map = new char[n][m];
    for (int i = 0; i < n; i++) {
      map[i] = br.readLine().toCharArray();
      for (int j = 0; j < m; j++) {
        char cur = map[i][j];
        if (cur == '@') {
          sp = new int[]{i, j};
        } else if (cur == '#' || cur == '*') {
          buildingCount.put(0, buildingCount.get(0) + 1);
        }
      }
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    for (int i = 0; i < 4; i++) {
      int nextX = sp[0] + dx[i];
      int nextY = sp[1] + dy[i];
      if (bfs(buildingCount, queue, map, nextX, nextY, n, m)) {
        int nextNextX = nextX + dx[i];
        int nextNextY = nextY + dy[i];
        bfs(buildingCount, queue, map, nextNextX, nextNextY, n, m);
      }
    }

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nextX = cur[0] + dx[i];
        int nextY = cur[1] + dy[i];
        bfs(buildingCount, queue, map, nextX, nextY, n, m);
      }
    }
    System.out.println(buildingCount.get(1) + " " + buildingCount.get(0));
  }

  public static boolean bfs(Map<Integer, Integer> buildingCount, Queue<int[]> queue, char[][] map,
      int x, int y, int n, int m) {
    if (x < 0 || x >= n || y < 0 || y >= m || map[x][y] == '|') {
      return false;
    }
    if (map[x][y] == '#') {
      map[x][y] = '*';
    } else if (map[x][y] == '*') {
      map[x][y] = '.';
      queue.add(new int[]{x, y});
      buildingCount.put(0, buildingCount.get(0) - 1);
      buildingCount.put(1, buildingCount.get(1) + 1);
    }
    return true;
  }
}
