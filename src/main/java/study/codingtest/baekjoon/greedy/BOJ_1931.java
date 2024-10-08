package study.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_1931 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    TreeMap<Integer, PriorityQueue<Integer>> endMap = new TreeMap<>();
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      endMap.putIfAbsent(end, new PriorityQueue<>());
      endMap.get(end).offer(start);
    }

    int count = 0;
    int start = 0;
    int end = 0;
    int lastEnd = endMap.lastKey();
    while (end <= lastEnd) {
      while (end <= lastEnd && (!endMap.containsKey(end) || endMap.get(end).isEmpty())) {
        endMap.remove(end);
        end++;
      }
      if (end > lastEnd) {
        break;
      }
      endMap.get(end).removeIf(v -> v < start);
      int curEnd = Optional.ofNullable(endMap.get(end).peek()).orElse(-1);
      if (curEnd < end) {
        end++;
        continue;
      }
      end = curEnd;
      endMap.get(end).poll();
      count++;
    }
    System.out.println(count);
  }
}
