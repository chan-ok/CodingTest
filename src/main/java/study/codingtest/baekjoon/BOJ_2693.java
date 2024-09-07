package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2693 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).sorted()
          .toArray();
      System.out.println(arr[7]);
    }
    br.close();
  }
}
