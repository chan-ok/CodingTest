package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_13420 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    for (int i = 0; i < n; i++) {
      String[] inputs = br.readLine().split(" ");
      long first = Long.parseLong(inputs[0]);
      String op = inputs[1];
      long second = Long.parseLong(inputs[2]);
      long answer = Long.parseLong(inputs[4]);

      long expect = 0;
      switch (op) {
        case "+":
          expect = first + second;
          break;
        case "-":
          expect = first - second;
          break;
        case "*":
          expect = first * second;
          break;
        case "/":
          expect = first / second;
          break;
      }

      System.out.println(answer == expect ? "correct" : "wrong answer");
    }

  }
}
