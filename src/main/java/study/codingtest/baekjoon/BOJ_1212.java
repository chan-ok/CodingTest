package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_1212 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    List<Integer> radix8 = Arrays.stream(reader.readLine().split("")).map(Integer::parseInt)
        .collect(Collectors.toList());

    StringBuilder result = new StringBuilder();
    for (int n : radix8) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 3; i++) {
        sb.append(n % 2);
        n /= 2;
      }
      result.append(sb.reverse());
    }
    String answer = result.toString();
    answer = answer.contains("1") ? answer.substring(answer.indexOf("1")) : "0";
    writer.write(answer);
    writer.flush();
  }
}