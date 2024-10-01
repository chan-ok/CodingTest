package study.codingtest.baekjoon.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1010 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      long result = combination(a, b);
      bw.write(String.valueOf(result));
      bw.newLine();
    }
    bw.flush();
  }

  public static long combination(int r, int n) {
    if (r > n - r) {
      r = n - r;
    }
    long result = 1;
    for (int i = 1; i <= r; i++) {
      result = result * (n - r + i) / i;
    }
    return result;
  }
}
