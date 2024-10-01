package study.codingtest.baekjoon.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1037 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int max = 2;
    int min = 1_000_000;
    String s = reader.readLine();
    StringTokenizer st = new StringTokenizer(reader.readLine());
    while (st.hasMoreTokens()) {
      int n = Integer.parseInt(st.nextToken());
      max = Math.max(max, n);
      min = Math.min(min, n);
    }
    writer.write(String.valueOf(max * min));
    writer.flush();
  }
}