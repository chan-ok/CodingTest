package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_25191 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int chicken = Integer.parseInt(br.readLine());
    int[] colaAndBeer = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

    int count = colaAndBeer[0] / 2 + colaAndBeer[1];
    System.out.println(Math.min(chicken, count));
  }

}
