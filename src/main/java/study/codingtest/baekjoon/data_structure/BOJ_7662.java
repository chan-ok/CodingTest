package study.codingtest.baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ_7662 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      int m = Integer.parseInt(br.readLine());
      TreeMap<Long, Integer> map = new TreeMap<>();
      for (int j = 0; j < m; j++) {
        String[] input = br.readLine().split(" ");
        String op = input[0];
        long num = Long.parseLong(input[1]);
        if (op.equals("I")) {
          map.put(num, map.getOrDefault(num, 0) + 1);
        } else if (op.equals("D")) {
          if (map.isEmpty()) {
            continue;
          }
          long key = num == 1 ? map.lastKey() : map.firstKey();
          int size = map.get(key);
          if (size > 1) {
            map.put(key, size - 1);
          } else {
            map.remove(key);
          }
        }
      }
      if (map.isEmpty()) {
        sb.append("EMPTY");
      } else {
        sb.append(map.lastKey()).append(" ").append(map.firstKey());
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
