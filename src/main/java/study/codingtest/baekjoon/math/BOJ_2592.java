package study.codingtest.baekjoon.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BOJ_2592 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < 10; i++) {
      int num = Integer.parseInt(reader.readLine());
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    AtomicInteger sum = new AtomicInteger();
    AtomicInteger freqKey = new AtomicInteger();
    AtomicInteger freqValue = new AtomicInteger();
    map.forEach((key, value) -> {
      if (value > freqValue.get()) {
        freqValue.set(value);
        freqKey.set(key);
      }
      sum.addAndGet(key * value);
    });
    writer.write(String.format("%d\n%d", sum.get() / 10, freqKey.get()));
    writer.flush();
  }
}