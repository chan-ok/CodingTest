package study.codingtest.BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_9613 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(reader.readLine());
    for (int i = 0; i < t; i++) {
      BigInteger sum = BigInteger.ZERO;
      List<Integer> list = Arrays.stream(reader.readLine().split(" "))
          .map(Integer::parseInt)
          .collect(Collectors.toList());
      for (int j = 1; j < list.get(0); j++) {
        for (int k = j + 1; k <= list.get(0); k++) {
          sum = sum.add(BigInteger.valueOf(gcd(list.get(j), list.get(k))));
        }
      }
      writer.write(sum.toString());
      writer.newLine();
    }
    writer.flush();
  }

  public static long gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  ;
}