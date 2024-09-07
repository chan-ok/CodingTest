package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BOJ_2581 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine());
    int n = Integer.parseInt(br.readLine());

    int[] arr = IntStream.rangeClosed(0, n).toArray();
    int pointer = 2;
    while (pointer < Math.sqrt(n)) {
      if (arr[pointer] == 0) {
        pointer++;
        continue;
      }
      for (int i = pointer + 1; i < arr.length; i++) {
        if (i % pointer == 0) {
          arr[i] = 0;
        }
      }
      pointer++;
    }
    int[] result = Arrays.stream(arr).skip(Math.max(2, m)).filter(i -> i != 0).toArray();
    if (result.length > 0) {
      System.out.println(Arrays.stream(result).sum());
      System.out.println(result[0]);
    } else {
      System.out.println(-1);
    }
    br.close();
  }
}
