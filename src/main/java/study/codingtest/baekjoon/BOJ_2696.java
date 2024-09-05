package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2696 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      int size = Integer.parseInt(br.readLine());
      bw.write(size / 2 + 1 + "\n");
      List<Integer> list = new LinkedList<>();
      for (int j = 0; j < size / 10 + 1; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int pointer = 0;
        while (st.hasMoreTokens()) {
          list.add(Integer.parseInt(st.nextToken()));
          if (pointer % 2 == 0) {
            list.sort(Comparator.comparingInt(s -> s));
            sb.append(list.get(list.size() / 2)).append(" ");
          }
          pointer++;
        }
        bw.write(sb.toString());
      }
      bw.newLine();
    }
    bw.flush();
  }
}
