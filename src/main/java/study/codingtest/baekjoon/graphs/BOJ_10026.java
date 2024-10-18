package study.codingtest.baekjoon.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class BOJ_10026 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[][] map = new String[n][n];
    Map<String, Set<int[]>> colorMap = new HashMap<>();

    for (int y = 0; y < n; y++) {
      map[y] = br.readLine().split("");
      for (int x = 0; x < n; x++) {
        String currentColor = map[y][x];
        colorMap.putIfAbsent(currentColor, new HashSet<>());
        colorMap.get(currentColor).add(new int[]{y, x});
      }
    }

    int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    Map<String, Integer> colorCountMap = new HashMap<>(Map.of("R", 0, "G", 0, "B", 0, "RG", 0));
    for (String color : colorCountMap.keySet()) {
      Map<Integer, Set<Integer>> visited = new HashMap<>();
      Queue<int[]> all = new ArrayDeque<>();
      for (String s : color.split("")) {
        all.addAll(colorMap.get(s));
      }
      while (!all.isEmpty()) {
        int[] start = all.poll();
        visited.putIfAbsent(start[0], new HashSet<>());
        visited.get(start[0]).add(start[1]);
        Queue<int[]> colorQueue = new ArrayDeque<>();
        colorQueue.offer(start);
        while (!colorQueue.isEmpty()) {
          int[] cur = colorQueue.poll();
          int[][] nextArr = Arrays.stream(directions)
              .map(next -> new int[]{cur[0] + next[0], cur[1] + next[1]})
              .filter(next -> next[0] >= 0 && next[0] < n && next[1] >= 0 && next[1] < n)
              .filter(next -> color.contains(map[next[0]][next[1]]))
              .toArray(int[][]::new);

          for (int[] next : nextArr) {
            if (visited.containsKey(next[0]) && visited.get(next[0]).contains(next[1])) {
              continue;
            }
            visited.putIfAbsent(next[0], new HashSet<>());
            visited.get(next[0]).add(next[1]);
            colorQueue.offer(next);
            all.removeIf(el -> el[0] == next[0] && el[1] == next[1]);
          }
        }
        colorCountMap.put(color, colorCountMap.get(color) + 1);
      }
    }
    int a = colorCountMap.entrySet().stream()
        .filter(entry -> !entry.getKey().equals("RG"))
        .map(Entry::getValue)
        .mapToInt(Integer::valueOf)
        .sum();
    int b = colorCountMap.entrySet().stream()
        .filter(entry -> !entry.getKey().equals("R") && !entry.getKey().equals("G"))
        .map(Entry::getValue)
        .mapToInt(Integer::valueOf)
        .sum();
    System.out.println(a + " " + b);
  }

}
