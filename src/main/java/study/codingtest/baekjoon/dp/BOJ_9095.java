package study.codingtest.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BOJ_9095 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<Integer> list = List.of(1, 2, 3);
    for (int i = 0; i < n; i++) {
      int m = Integer.parseInt(br.readLine());
      int result = 0;
      Queue<Integer> q = new LinkedList<>(list);

      while(!q.isEmpty()) {
        int cur = q.poll();
        if (cur == m) {
          result++;
        } else if (cur < m) {
          for (int j : list) {
            q.add(cur + j);
          }
        }
      }
      System.out.println(result);
    }
  }
}