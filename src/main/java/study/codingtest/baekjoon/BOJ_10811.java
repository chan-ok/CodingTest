package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BOJ_10811 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    List<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
    for (int i = 0; i < m; i++) {
      StringTokenizer round = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(round.nextToken()) - 1;
      int end = Integer.parseInt(round.nextToken());
      Deque<Integer> stack = new ArrayDeque<>();
      for (int j = start; j < end; j++) {
        stack.push(list.get(j));
      }
      for (int j = start; j < end; j++) {
        list.set(j, stack.pop());
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int j : list) {
      sb.append(j).append(" ");
    }
    System.out.println(sb);
  }

}
