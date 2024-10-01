package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1003 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());
      Map<Integer, Integer[]> calculated = new HashMap<>();
      calculated.put(0, new Integer[]{1, 0});
      calculated.put(1, new Integer[]{0, 1});
      Integer[] result = fibonacci(calculated,  N);
      System.out.println(result[0] + " " + result[1]);
    }
  }

  public static Integer[] fibonacci(Map<Integer, Integer[]> calculated, int n) {
    if (calculated.containsKey(n)) {
      return calculated.get(n);
    }
    Integer[] f1 = fibonacci(calculated,  n - 1);
    Integer[] f2 = fibonacci(calculated,  n - 2);
    Integer[] result = new Integer[]{ f1[0] + f2[0], f1[1] + f2[1] };
    calculated.put(n, result);
    return result;
  }
}
