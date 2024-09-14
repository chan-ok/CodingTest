package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25304 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long all = Long.parseLong(br.readLine());
    long sum = 0;
    short n = Short.parseShort(br.readLine());
    for (short i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int price = Integer.parseInt(st.nextToken());
      int count = Integer.parseInt(st.nextToken());
      sum += (long) price * count;
    }
    System.out.println(all == sum ? "Yes" : "No");
  }

}
