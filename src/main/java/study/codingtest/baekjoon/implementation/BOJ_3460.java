package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_3460 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(reader.readLine());
    for (int i = 0; i < T; i++) {
      int n = Integer.parseInt(reader.readLine());
      int idx = 0;
      while (n > 0) {
        if (n % 2 == 1) {
          writer.write(idx + " ");
        }
        n /= 2;
        idx++;
      }
      writer.write("\n");
    }
    writer.flush();
  }
}