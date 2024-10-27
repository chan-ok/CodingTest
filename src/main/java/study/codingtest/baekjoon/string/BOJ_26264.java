package study.codingtest.baekjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_26264 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    char[] input = br.readLine().toCharArray();

    int security = 0;
    int bigdata = 0;
    for (int i = 0; i < input.length; ) {
      if (input[i] == 's') {
        security++;
        i += 8;
      } else {
        bigdata++;
        i += 7;
      }
    }

    if (security > bigdata) {
      System.out.println("security!");
    } else if (security < bigdata) {
      System.out.println("bigdata?");
    } else {
      System.out.println("bigdata? security!");
    }
  }

}
