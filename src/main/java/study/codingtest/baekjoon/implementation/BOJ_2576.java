package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2576 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int sum = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < 7; i++) {
      int n = Integer.parseInt(reader.readLine());
      if (n % 2 == 1) {
        sum += n;
        min = Math.min(min, n);
      }
    }
    if (sum == 0) {
      writer.write("-1");
    } else {
      writer.write(sum + "\n" + min);
    }
    writer.flush();
  }
}