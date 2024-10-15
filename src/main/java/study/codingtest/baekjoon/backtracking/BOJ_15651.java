package study.codingtest.baekjoon.backtracking;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class BOJ_15651 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    SortedSet<int[]> result = new TreeSet<>((a, b) -> {
      for (int i = 0; i < m; i++) {
        if (a[i] != b[i]) {
          return a[i] - b[i];
        }
      }
      return 0;
    });
    List<Integer> range = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());

    StringBuilder sb = new StringBuilder();
    dfs(result, range, m, new ArrayDeque<>());
    for (int[] arr : result) {
      Arrays.stream(arr).forEach(i -> sb.append(i).append(" "));
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static void dfs(SortedSet<int[]> result, List<Integer> range, int size,
      ArrayDeque<Integer> combination) {
    if (size == 0) {
      result.add(combination.stream().mapToInt(Integer::valueOf).toArray());
      return;
    }
    for (int i = 0; i < range.size(); i++) {
      combination.add(range.get(i));
      dfs(result, range, size - 1, combination);
      combination.pollLast();
    }
  }
}
