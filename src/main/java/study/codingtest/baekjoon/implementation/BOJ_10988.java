package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10988 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = reader.readLine();
    String reversed = new StringBuilder(input).reverse().toString();
    writer.write(input.equals(reversed) ? "1" : "0");
    writer.flush();
  }
}