package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BOJ_5622 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<String, Integer> numberMap = Map.of(
                "ABC", 3,
                "DEF", 4,
                "GHI", 5,
                "JKL", 6,
                "MNO", 7,
                "PQRS", 8,
                "TUV", 9,
                "WXYZ", 10
            );

    AtomicInteger sum = new AtomicInteger(0);
    String[] keywords = br.readLine().split("");
    for (String keyword : keywords) {
      numberMap.entrySet().stream()
          .filter(e -> e.getKey().contains(keyword))
          .findFirst()
          .ifPresent(e -> sum.addAndGet(e.getValue()));
    }
    System.out.println(sum);
    br.close();
  }
}
