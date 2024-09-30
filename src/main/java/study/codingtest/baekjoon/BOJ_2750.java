package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class BOJ_2750 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    Set<Integer> set = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(br.readLine());
      set.add(x);
    }
    for (int j : set) {
      sb.append(j).append("\n");
    }
    System.out.println(sb);
  }
}
