package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_2745 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    String n = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringTokenizer st = new StringTokenizer(reader.readLine());
    String[] chars = new StringBuilder(st.nextToken()).reverse().toString().split("");
    int b = Integer.parseInt(st.nextToken());
    BigInteger result = BigInteger.ZERO;
    long i = 1;
    for (String s : chars) {
      int num = n.indexOf(s);
      result = result.add(BigInteger.valueOf(num).multiply(BigInteger.valueOf(i)));
      i *= b;
    }
    writer.write(result.toString());
    writer.flush();
  }
}