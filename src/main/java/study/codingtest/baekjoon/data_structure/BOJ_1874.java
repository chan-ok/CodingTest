package study.codingtest.baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_1874 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    Deque<Integer> stack = new ArrayDeque<>();
    int x = 1;
    for (int i = 0; i < n; i++) {
      int cur = Integer.parseInt(br.readLine());
      while (cur >= x) {
        sb.append("+").append("\n");
        stack.push(x);
        x++;
      }
      if (!stack.isEmpty() && stack.peek() == cur) {
        sb.append("-").append("\n");
        stack.pop();
      } else {
        System.out.println("NO");
        return;
      }
    }
    System.out.println(sb);
  }
}
