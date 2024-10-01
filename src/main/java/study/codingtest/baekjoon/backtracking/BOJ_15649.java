package study.codingtest.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BOJ_15649 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(reader.readLine());
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

    dfs(result, range, m, new ArrayDeque<>());
    for (int[] arr : result) {
      StringBuilder sb = new StringBuilder();
      Arrays.stream(arr).forEach(i -> sb.append(i).append(" "));
      writer.write(sb.toString());
      writer.newLine();
    }
    writer.flush();
  }

  public static void dfs(SortedSet<int[]> result, List<Integer> range, int size,
      ArrayDeque<Integer> combination) {
    if (size == 0) {
      result.add(combination.stream().mapToInt(Integer::valueOf).toArray());
      return;
    }
    for (int i = 0; i < range.size(); i++) {
      combination.add(range.remove(i));
      dfs(result, range, size - 1, combination);
      range.add(i, combination.pollLast());
    }
  }
}