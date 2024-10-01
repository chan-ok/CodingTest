package study.codingtest.baekjoon.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class BOJ_1373 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = new StringBuilder(reader.readLine()).reverse().toString();
    Deque<Integer> radix2 = Arrays.stream(input.split("")).map(Integer::parseInt)
        .collect(Collectors.toCollection(java.util.ArrayDeque::new));

    StringBuilder result = new StringBuilder();
    int count = 0;
    int num = 0;
    while (!radix2.isEmpty()) {
      num += (int) (radix2.pollFirst() * Math.pow(2, count));
      count++;
      if (count == 3 || radix2.isEmpty()) {
        result.append(num);
        count = 0;
        num = 0;
      }
    }
    writer.write(result.reverse().toString());
    writer.flush();
  }
}