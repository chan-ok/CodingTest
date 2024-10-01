package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BOJ_10813 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    List<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
    for (int i = 0; i < m; i++) {
      StringTokenizer round = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(round.nextToken()) - 1;
      int b = Integer.parseInt(round.nextToken()) - 1;
      Collections.swap(list, a, b);
    }
    StringBuilder sb = new StringBuilder();
    for (int j : list) {
      sb.append(j).append(" ");
    }
    System.out.println(sb);
  }

}
