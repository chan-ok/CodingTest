package study.codingtest.baekjoon.divide_n_conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class BOJ_1541 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<String, SortedSet<Integer>> memo = new HashMap<>();
    String expression = br.readLine();
    SortedSet<Integer> result = diffWaysToCompute(memo, expression);
    System.out.println(result.first());
  }

  public static SortedSet<Integer> diffWaysToCompute(Map<String, SortedSet<Integer>> memo,
      String expression) {
    if (memo.containsKey(expression)) {
      return memo.get(expression);
    }

    SortedSet<Integer> result = new TreeSet<>();
    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);
      if (c == '+' || c == '-') {
        SortedSet<Integer> left = diffWaysToCompute(memo, expression.substring(0, i));
        SortedSet<Integer> right = diffWaysToCompute(memo, expression.substring(i + 1));

        if (c == '+') {
          result.add(left.first() + right.first());
          result.add(left.last() + right.last());
        } else {
          result.add(left.first() - right.last());
          result.add(left.last() - right.first());
        }
      }
    }

    if (result.isEmpty()) {
      int value = Integer.parseInt(expression);
      result.add(value);
    }
    memo.put(expression, result);
    return result;
  }
}
