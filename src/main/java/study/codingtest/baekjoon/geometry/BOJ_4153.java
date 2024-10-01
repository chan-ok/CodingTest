package study.codingtest.baekjoon.geometry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_4153 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true) {
      List<Integer> list = Arrays.stream(br.readLine().split(" "))
          .map(Integer::parseInt)
          .sorted()
          .collect(Collectors.toList());

      if (list.stream().allMatch(i -> i == 0)) {
        break;
      }

      if (list.get(0) * list.get(0) + list.get(1) * list.get(1) == list.get(2) * list.get(2)) {
        bw.write("right");
      } else {
        bw.write("wrong");
      }
      bw.newLine();
    }
    bw.flush();
  }
}
