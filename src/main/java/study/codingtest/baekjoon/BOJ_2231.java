package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class BOJ_2231 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = IntStream.rangeClosed(1, 1_000_000).toArray();
    int result = 0;
    for (int i : arr) {
      int sum = 0;
      int cur = i;
      while (cur > 0) {
        sum += cur % 10;
        cur = cur / 10;
      }
      if (sum + i == n) {
        result = i;
        break;
      }
    }

    System.out.println(result);
  }
}
