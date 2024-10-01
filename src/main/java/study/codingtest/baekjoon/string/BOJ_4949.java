package study.codingtest.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class BOJ_4949 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Map<Character, Character> map = Map.of(
        ')', '(',
        ']', '['
    );
    while (true) {
      String input = br.readLine();
      if (input.equals(".")) {
        break;
      }
      Deque<Character> stack = new ArrayDeque<>();
      char[] chars = input.replaceAll("[a-zA-Z\\s.]+", "").toCharArray();
      for (char c : chars) {
        if (map.containsValue(c)) {
          stack.push(c);
        } else {
          if (!stack.isEmpty() && map.get(c).equals(stack.peek())) {
            stack.pop();
          } else {
            stack.push(c);
          }
        }
      }
      sb.append(stack.isEmpty() ? "yes" : "no").append("\n");
    }
    System.out.println(sb);
  }

}
