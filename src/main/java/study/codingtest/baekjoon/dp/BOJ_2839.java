package study.codingtest.baekjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2839 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    bw.write(String.valueOf(countSugar(n)));
    bw.flush();
  }

  private static int countSugar(int n) {
    for (int i = n / 5; i >= 0; i--) {
      int weight = n;
      weight -= 5 * i;
      if (weight % 3 == 0) {
        return i + weight / 3;
      }
    }
    return -1;
  }
}