package study.codingtest.BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2443 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(reader.readLine());
    for (int i = n; i > 0; i--) {
      writer.write(" ".repeat(n - i) + "*".repeat(2 * i - 1));
      writer.newLine();
    }
    writer.flush();
  }
}