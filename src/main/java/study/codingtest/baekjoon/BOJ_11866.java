package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11866 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      queue.offer(i);
    }

    int count = 0;
    StringBuilder sb = new StringBuilder("<");
    while (!queue.isEmpty()) {
      count++;
      int person = queue.poll();
      if (count == k) {
        sb.append(person).append(", ");
        count = 0;
        continue;
      }
      queue.offer(person);
    }
    int lastIndex = sb.lastIndexOf(",");
    sb.replace(lastIndex, sb.length(), ">");
    bw.write(sb.toString());
    bw.flush();
  }

}
