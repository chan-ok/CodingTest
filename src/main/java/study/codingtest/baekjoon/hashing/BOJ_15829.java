package study.codingtest.baekjoon.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_15829 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(br.readLine());
    char[] chars = br.readLine().toCharArray();

    BigInteger sum = BigInteger.ZERO;
    for (int i = 0; i < size; i++) {
      int alphbetNumber = chars[i] - 'a' + 1;
      BigInteger value = BigInteger.valueOf(31L).pow(i).multiply(BigInteger.valueOf(alphbetNumber));
      sum = sum.add(value);
    }
    BigInteger hash = sum.mod(BigInteger.valueOf(1234567891L));
    System.out.println(hash);
  }
}
