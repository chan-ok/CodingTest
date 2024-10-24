package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_16674 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split("");
    List<String> _2018 = Arrays.asList("2", "0", "1", "8");
    Map<String, Integer> count = new HashMap<>();

    for (String s : input) {
      if (_2018.contains(s)) {
        count.put(s, count.getOrDefault(s, 0) + 1);
      } else {
        count.put("n", count.getOrDefault("n", 0) + 1);
      }
    }

    if (count.containsKey("n")) {
      System.out.println(0);
    } else {
      if (count.containsKey("2") && count.containsKey("0") && count.containsKey("1")
          && count.containsKey("8")) {
        int a = count.get("2");
        if (a == count.get("1") && a == count.get("0") && a == count.get("8")) {
          System.out.println(8);
        } else {
          System.out.println(2);
        }
      } else {
        System.out.println(1);
      }
    }
  }
}
