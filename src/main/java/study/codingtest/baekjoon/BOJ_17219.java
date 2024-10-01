package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_17219 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    Map<String, String> passwordMap = new HashMap<>();
    int N = Integer.parseInt(st.nextToken());
    for (int i = 0; i < N; i++) {
      StringTokenizer siteAndPw = new StringTokenizer(br.readLine());
      String site = siteAndPw.nextToken();
      String password = siteAndPw.nextToken();
      passwordMap.put(site, password);
    }

    StringBuilder sb = new StringBuilder();
    int M = Integer.parseInt(st.nextToken());
    for (int i = 0; i < M; i++) {
      String target = br.readLine();
      sb.append(passwordMap.get(target)).append("\n");
    }

    System.out.println(sb);
  }
}
