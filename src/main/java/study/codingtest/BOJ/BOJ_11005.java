package study.codingtest.BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_11005 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    char[] n = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
        'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
        'X', 'Y', 'Z'};
    StringTokenizer st = new StringTokenizer(reader.readLine());
    BigInteger a = new BigInteger(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    StringBuilder sb = new StringBuilder();
    while (!a.equals(BigInteger.ZERO)) {
      sb.append(n[a.mod(BigInteger.valueOf(b)).intValue()]);
      a = a.divide(BigInteger.valueOf(b));
    }
    if (sb.length() == 0) {
      sb.append(0);
    }
    writer.write(sb.reverse().toString());
    writer.flush();
  }
}