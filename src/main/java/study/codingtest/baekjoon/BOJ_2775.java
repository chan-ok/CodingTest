package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class BOJ_2775 {

  private static final Map<Integer, Map<Integer, Integer>> calculated = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      int k = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      sb.append(calc(k - 1, n)).append("\n");
    }
    System.out.println(sb);
  }

  public static int calc(int k, int n) {
    if (!calculated.containsKey(k)) {
      calculated.put(k, new HashMap<>());
    }
    if (calculated.get(k).containsKey(n)) {
      return calculated.get(k).get(n);
    }

    IntStream stream = IntStream.rangeClosed(1, n);
    int sum = k == 0 ? stream.sum() : stream.map(i -> calc(k - 1, i)).sum();
    calculated.get(k).put(n, sum);
    return sum;
  }
}
