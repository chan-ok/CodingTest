package study.codingtest.BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5598 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String kaisar = "DEFGHIJKLMNOPQRSTUVWXYZABC";

    String[] encrypt = reader.readLine().split("");
    StringBuilder sb = new StringBuilder();

    for (String s : encrypt) {
      int index = kaisar.indexOf(s);
      sb.append(alphabet.charAt(index));
    }
    writer.write(sb.toString());
    writer.flush();
  }
}