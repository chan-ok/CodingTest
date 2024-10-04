package study.codingtest.baekjoon.dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_2579 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<Integer> stairs = new ArrayList<>();
    stairs.add(0);
    for (int i = 0; i < n; i++) {
      stairs.add(Integer.parseInt(br.readLine()));
    }
    Map<Integer, Integer> calculated = new HashMap<>();
    calculated.put(0, 0);
    if (n >= 1) {
      calculated.put(1, stairs.get(1));
    }
    if (n >= 2) {
      calculated.put(2, stairs.get(1) + stairs.get(2));
    }
    System.out.println(calc(calculated, stairs, n));
  }

  public static int calc(Map<Integer, Integer> calculated,List<Integer> stairs, int n) {
    if (calculated.containsKey(n)) {
      return calculated.get(n);
    }
    int max = Math.max(stairs.get(n - 1) + calc(calculated, stairs, n - 3), calc(calculated, stairs, n - 2));
    calculated.put(n, max + stairs.get(n));
    return calculated.get(n);
  }
}