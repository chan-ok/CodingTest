package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1074 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken()) + 1;
    int c = Integer.parseInt(st.nextToken()) + 1;

    int size = (int) Math.pow(2, N);
    int result = 0;

    while (size > 1) {
      size /= 2;
      int side = 0;
      if (r > size) {
        r -= size;
        side += 2;
      }
      if (c > size) {
        c -= size;
        side += 1;
      }
      result += size * size * side;
    }
    System.out.println(result);
  }
}
