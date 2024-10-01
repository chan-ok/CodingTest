package study.codingtest.baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2696 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = null;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int size = Integer.parseInt(br.readLine());
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

      sb.append(((size + 1) / 2)).append("\n");

      for (int j = 0; j < size; j++) {
        if (j % 10 == 0) {
          st = new StringTokenizer(br.readLine());
        }
        int num = Integer.parseInt(st.nextToken());
        if (maxHeap.size() == minHeap.size()) {
          maxHeap.offer(num);
        } else {
          minHeap.offer(num);
        }

        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
          int t1 = maxHeap.poll();
          int t2 = minHeap.poll();
          maxHeap.offer(t2);
          minHeap.offer(t1);
        }


        if (j % 2 == 0) {
          sb.append(maxHeap.peek());
          if ((j + 2) % 20 == 0 || j == size - 1) {
            sb.append("\n");
          } else {
            sb.append(" ");
          }
        }
      }
    }
    bw.write(sb.toString());
    bw.flush();
  }

}
