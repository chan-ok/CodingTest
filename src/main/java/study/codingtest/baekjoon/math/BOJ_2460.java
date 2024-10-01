package study.codingtest.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2460 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int people = 0, max = 0;
    for (int i = 0; i < 10; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      people = people - Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
      max = Integer.max(max, people);
    }
    System.out.println(max);
    br.close();
  }

}
