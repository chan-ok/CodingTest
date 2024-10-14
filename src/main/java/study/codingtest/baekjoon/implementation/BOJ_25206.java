package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_25206 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<String, Double> gradeMap = Map.of(
        "A+", 4.5,
        "A0", 4.0,
        "B+", 3.5,
        "B0", 3.0,
        "C+", 2.5,
        "C0", 2.0,
        "D+", 1.5,
        "D0", 1.0,
        "F", 0.0
    );
    double sum1 = 0;
    double sum2 = 0;
    for (int i = 0; i < 20; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      st.nextToken();
      double score = Double.parseDouble(st.nextToken());
      String grade = st.nextToken();
      if (grade.equals("P")) {
        continue;
      }
      sum1 += score * gradeMap.get(grade);
      sum2 += score;
    }
    System.out.println(sum1 / sum2);
  }

}
