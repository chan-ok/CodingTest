package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_11651 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    Comparator<Integer[]> comparator = (o1, o2) -> o1[1].equals(o2[1]) ? o1[0] - o2[0]
        : o1[1] - o2[1];
    Set<Integer[]> set = new TreeSet<>(comparator);

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      set.add(new Integer[]{x, y});
    }

    for (Integer[] arr : set) {
      System.out.println(arr[0] + " " + arr[1]);
    }
  }

}
