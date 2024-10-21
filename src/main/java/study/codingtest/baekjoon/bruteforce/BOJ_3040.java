package study.codingtest.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_3040 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[9];
    for (int i = 0; i < 9; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    for (int p1 = 0; p1 < arr.length - 6; p1++) {
      for (int p2 = p1 + 1; p2 < arr.length - 5; p2++) {
        for (int p3 = p2 + 1; p3 < arr.length - 4; p3++) {
          for (int p4 = p3 + 1; p4 < arr.length - 3; p4++) {
            for (int p5 = p4 + 1; p5 < arr.length - 2; p5++) {
              for (int p6 = p5 + 1; p6 < arr.length - 1; p6++) {
                for (int p7 = p6 + 1; p7 < arr.length; p7++) {
                  if (arr[p1] + arr[p2] + arr[p3] + arr[p4] + arr[p5] + arr[p6] + arr[p7] == 100) {
                    System.out.println(arr[p1]);
                    System.out.println(arr[p2]);
                    System.out.println(arr[p3]);
                    System.out.println(arr[p4]);
                    System.out.println(arr[p5]);
                    System.out.println(arr[p6]);
                    System.out.println(arr[p7]);
                    return;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}
