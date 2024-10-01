package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      Queue<Doc> queue = new LinkedList<>();
      int size = Integer.parseInt(st.nextToken());
      int target = Integer.parseInt(st.nextToken());
      int[] priorities = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::valueOf)
          .toArray();
      for (int j = 0; j < size; j++) {
        queue.offer(new Doc(j, priorities[j]));
      }
      int count = 0;
      while (!queue.isEmpty()) {
        Doc doc = queue.poll();
        if (queue.stream().anyMatch(wait -> wait.priority > doc.priority)) {
          queue.offer(doc);
        } else {
          count++;
          if (target == doc.index) {
            bw.write(String.valueOf(count));
            bw.newLine();
          }
        }
      }
    }
    bw.flush();
  }

  public static class Doc {

    int index;
    int priority;

    public Doc(int index, int priority) {
      this.index = index;
      this.priority = priority;
    }
  }

}
