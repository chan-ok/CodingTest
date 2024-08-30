package study.codingtest.BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2490 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int i = 0; i < 3; i++) {
      String[] input = reader.readLine().split(" ");
      int count = 0;
      for (String s : input) {
        if (s.equals("0")) {
          count++;
        }
      }
      switch (count) {
        case 0:
          writer.write("E\n");
          break;
        case 1:
          writer.write("A\n");
          break;
        case 2:
          writer.write("B\n");
          break;
        case 3:
          writer.write("C\n");
          break;
        case 4:
          writer.write("D\n");
          break;
      }

    }
    writer.flush();
  }
}