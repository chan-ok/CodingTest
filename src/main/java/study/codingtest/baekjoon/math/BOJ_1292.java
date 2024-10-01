package study.codingtest.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class BOJ_1292 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int sum = IntStream.generate(new IntSupplier() {
      int count = 0;
      int num = 1;

      @Override
      public int getAsInt() {
        if (count == num) {
          num++;
          count = 0;
        }
        count++;
        return num;
      }
    }).limit(m).skip(n - 1).sum();
    System.out.println(sum);
    br.close();
  }
}
