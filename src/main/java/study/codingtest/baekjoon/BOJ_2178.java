package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_2178 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] map = new int[N][M];
    for (int i = 0; i < N; i++) {
      map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::valueOf).toArray();
    }
    Map<Integer, Map<Integer, Integer>> visited = new HashMap<>();
    visited.put(0, new HashMap<>());
    visited.get(0).put(0, 1);
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    Queue<Integer[]> queue = new LinkedList<>();
    queue.offer(new Integer[]{0, 0});

    while(!queue.isEmpty()) {
      Integer[] cur = queue.poll();
      List<Integer[]> nexts = Arrays.stream(directions)
          .map(d -> new Integer[]{cur[0] + d[0],cur[1] + d[1] })
          .filter(d -> d[0] >= 0 && d[0] < N && d[1] >= 0 && d[1] < M && map[d[0]][d[1]] == 1)
          .collect(Collectors.toList());
      for (Integer[] next : nexts) {
        if (visited.containsKey(next[0]) && visited.get(next[0]).containsKey(next[1])) {
          continue;
        }
        visited.putIfAbsent(next[0], new HashMap<>());
        visited.get(next[0]).put(next[1], visited.get(cur[0]).get(cur[1]) + 1);
        queue.offer(next);
      }
    }

    System.out.println(visited.get(N - 1).get(M - 1));
  }
}
