package study.codingtest.baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_9375 {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for (int i = 0; i < T; i++) {
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> clothes = new HashMap<>();
        for (int j = 0; j < n; j++) {
          String type = br.readLine().split(" ")[1];
          clothes.put(type, clothes.getOrDefault(type, 0) + 1);
        }

        int[] values = clothes.values().stream().mapToInt(Integer::valueOf).toArray();
        int count = 1;
        for (int size = 0; size < clothes.size(); size++) {
          count *= values[size] + 1;
        }
        System.out.println(count - 1);
      }
    }
}
