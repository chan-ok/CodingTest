package study.codingtest.baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1620 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    Map<Integer, String> pokemonIndexMap = new HashMap<>();
    Map<String, Integer> pokemonNameMap = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      String name = br.readLine();
      pokemonIndexMap.put(i, name);
      pokemonNameMap.put(name, i);
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      String input = br.readLine();
      if (Character.isDigit(input.charAt(0))) {
        sb.append(pokemonIndexMap.get(Integer.parseInt(input))).append("\n");
      } else {
        sb.append(pokemonNameMap.get(input)).append("\n");
      }
    }
    System.out.println(sb);
  }

}
