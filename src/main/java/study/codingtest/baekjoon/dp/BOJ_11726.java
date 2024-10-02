package study.codingtest.baekjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class BOJ_11726 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Map<Integer, BigInteger> calculated = new HashMap<>();
    calculated.put(1, BigInteger.ONE);
    calculated.put(2, BigInteger.TWO);
    System.out.println(calc(calculated, n));
  }

  public static BigInteger calc(Map<Integer, BigInteger> calculated, int n) {
    if (calculated.containsKey(n)) {
      return calculated.get(n);
    }
    calculated.put(n, calc(calculated, n-1).add(calc(calculated, n-2)));
    return calculated.get(n).mod(BigInteger.valueOf(10007));
  }
}