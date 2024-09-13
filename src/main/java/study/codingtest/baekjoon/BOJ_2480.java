package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class BOJ_2480 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < 3; i++) {
      int n = Integer.parseInt(st.nextToken());
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    if (map.size() == 1) {
      System.out.println(10000 + map.keySet().iterator().next() * 1000);
    } else if (map.size() == 2) {
      int value = map.entrySet().stream()
          .filter(e -> e.getValue() == 2)
          .findFirst()
          .map(Entry::getKey)
          .orElseThrow();
      System.out.println(1000 + value * 100);
    } else {
      int value = map.keySet().stream()
          .mapToInt(Integer::intValue)
          .max()
          .getAsInt();
      System.out.println(value * 100);
    }
    br.close();
  }
}
