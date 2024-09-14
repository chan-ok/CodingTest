package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1018 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    String[][] tiles = new String[m][n];
    for (int i = 0; i < m; i++) {
      tiles[i] = br.readLine().split("");
    }

    int min = Integer.MAX_VALUE;
    for (int y = 0; y < m - 7; y++) {
      for (int x = 0; x < n - 7; x++) {
        for (String color : List.of("W", "B")) {
          int count = 0;
          String nextColor = color.equals("W") ? "B" : "W";
          List<String> list = List.of(color, nextColor);

          for (int curY = y; curY < y + 8; curY++) {
            for (int curX = x; curX < x + 8; curX++) {
              String currentColor = tiles[curY][curX];
              String needColor = list.get((curY + curX) % 2);
              if (!currentColor.equals(needColor)) {
                count++;
              }
            }
          }
          min = Integer.min(min, count);
        }
      }
    }
    System.out.println(min);
  }
}
