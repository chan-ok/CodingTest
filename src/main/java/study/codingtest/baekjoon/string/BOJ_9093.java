package study.codingtest.baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9093 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(reader.readLine());
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(reader.readLine());
      StringBuilder sb = new StringBuilder();
      while (st.hasMoreTokens()) {
        sb.append(new StringBuilder(st.nextToken()).reverse()).append(" ");
      }
      writer.write(sb.toString());
      writer.newLine();
    }
    writer.flush();
  }
}