package study.codingtest.baekjoon.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2729 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(reader.readLine());
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(reader.readLine());
      String a = new StringBuilder(st.nextToken()).reverse().toString();
      String b = new StringBuilder(st.nextToken()).reverse().toString();
      writer.write(binarySum(a, b));
      writer.newLine();
    }
    writer.flush();
  }

  public static String binarySum(String a, String b) {
    StringBuilder result = new StringBuilder();
    int carry = 0;
    for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
      int sum = carry;
      if (i < a.length()) {
        sum += a.charAt(i) - '0';
      }
      if (i < b.length()) {
        sum += b.charAt(i) - '0';
      }
      result.append(sum % 2);
      carry = sum / 2;
    }
    if (carry > 0) {
      result.append(carry);
    }
    String resultStr = result.reverse().toString();
    return resultStr.indexOf('1') == -1 ? "0" : resultStr.substring(resultStr.indexOf('1'));
  }
}