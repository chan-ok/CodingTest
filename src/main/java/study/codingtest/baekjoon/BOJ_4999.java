package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_4999 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String jaehwan = br.readLine();
    String doctor = br.readLine();

    System.out.println(jaehwan.length() >= doctor.length() ? "go" : "no");
  }
}
