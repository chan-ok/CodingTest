package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2442 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(reader.readLine());
    for (int i = 1; i <= n; i++) {
      writer.write(" ".repeat(n - i) + "*".repeat(2 * i - 1));
      writer.newLine();
    }
    writer.flush();
  }
}