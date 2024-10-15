package study.codingtest.baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_5430 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      char[] operations = br.readLine().toCharArray();
      br.readLine();
      Deque<String> deque = Arrays.stream(br.readLine()
              .replaceAll("[\\[\\]]", "")
              .split(","))
          .filter(s -> !s.isBlank())
          .collect(Collectors.toCollection(ArrayDeque::new));
      int pointer = 1;
      for (char op : operations) {
        switch (op) {
          case 'R':
            pointer *= -1;
            break;
          case 'D':
            if (!deque.isEmpty()) {
              if (pointer == 1) {
                deque.removeFirst();
              } else {
                deque.removeLast();
              }
            } else {
              pointer = 0;
            }
            break;
        }
      }
      List<String> result = new ArrayList<>();
      while (!deque.isEmpty()) {
        result.add(pointer == 1 ? deque.pollFirst() : deque.pollLast());
      }
      if (pointer == 0) {
        sb.append("error\n");
      } else {
        sb.append("[").append(String.join(",", result)).append("]\n");
      }
    }
    System.out.println(sb);
  }
}
