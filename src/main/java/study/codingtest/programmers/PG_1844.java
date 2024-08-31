package study.codingtest.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PG_1844 {

  Queue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));

  public void findPath(int x, int y, int distance, int[][] maps) {
    if (x >= 0 && x < maps[0].length
        && y >= 0 && y < maps.length
        && maps[y][x] != 0) {
      maps[y][x] = 0;
      pq.add(new Point(x, y, distance + 1));
    }
  }

  public int solution(int[][] maps) {
    pq.add(new Point(0, 0, 1));
    while (!pq.isEmpty()) {
      Point cur = pq.poll();
      int x = cur.x;
      int y = cur.y;
      int distance = cur.distance;
      if (x == maps[0].length - 1 && y == maps.length - 1) {
        return cur.distance;
      }
      findPath(x, y + 1, distance, maps);
      findPath(x, y - 1, distance, maps);
      findPath(x + 1, y, distance, maps);
      findPath(x - 1, y, distance, maps);
    }
    return -1;
  }

  static class Point {

    int x;
    int y;
    int distance;

    public Point(int x, int y, int distance) {
      this.x = x;
      this.y = y;
      this.distance = distance;
    }
  }
}
