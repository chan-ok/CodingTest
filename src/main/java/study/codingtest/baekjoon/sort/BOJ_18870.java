package study.codingtest.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class BOJ_18870 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Map<Integer, Integer> group = new TreeMap<>();
    Integer[] inputArr = Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf)
        .toArray(Integer[]::new);
    for (int input : inputArr) {
      group.put(input, 1);
    }

    Set<Integer> keys = group.keySet();
    Integer[] values = group.values().toArray(Integer[]::new);
    int[] prefixSum = new int[values.length + 1];

    int i = 0;
    Map<Integer, Integer> result = new HashMap<>();
    for (int key : keys) {
      prefixSum[i + 1] = prefixSum[i] + values[i];
      result.put(key, prefixSum[i]);
      i++;
    }

    StringBuilder sb = new StringBuilder();
    for (int input : inputArr) {
      sb.append(result.get(input)).append(" ");
    }
    System.out.println(sb);
  }
}
