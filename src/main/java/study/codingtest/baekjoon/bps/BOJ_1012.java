package study.codingtest.baekjoon.bps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_1012 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    Point[] directions = {
        new Point(0, 1),
        new Point(0, -1),
        new Point(1, 0),
        new Point(-1, 0)
    };

    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int[][] map = new int[n][m];
      ArrayDeque<Point> all = new ArrayDeque<>();
      Set<Point> visited = new HashSet<>();

      for (int j = 0; j < s; j++) {
        StringTokenizer xy = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(xy.nextToken());
        int y = Integer.parseInt(xy.nextToken());
        all.offer(new Point(y, x));
        map[y][x] = 1;
      }

      int count = 0;
      while (!all.isEmpty()) {
        Queue<Point> queue = new ArrayDeque<>();
        Point start = all.poll();
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
          Point cur = queue.poll();
          List<Point> nexts = Arrays.stream(directions)
              .map(d -> new Point(cur.y + d.y, cur.x + d.x))
              .filter(next -> next.y >= 0 && next.y < n && next.x >= 0 && next.x < m
                  && map[next.y][next.x] == 1)
              .collect(Collectors.toList());

          for (Point next : nexts) {
            if (visited.contains(next)) {
              continue;
            }
            all.remove(next);
            queue.offer(next);
            visited.add(next);
          }
        }
        count++;
      }
      sb.append(count).append("\n");
    }
    System.out.println(sb);
  }

  public static class Point {

    int y;
    int x;

    public Point(int y, int x) {
      this.y = y;
      this.x = x;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj instanceof Point) {
        Point p = (Point) obj;
        return p.x == this.x && p.y == this.y;
      }
      return false;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.x, this.y);
    }
  }
}
