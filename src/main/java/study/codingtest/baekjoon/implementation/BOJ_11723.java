package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11723 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    MySet set = new MySet();
    StringBuilder sb = new StringBuilder();
    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++) {
      String[] input = br.readLine().split(" ");
      String cmd = input[0];
      int x = 0;
      if (input.length > 1) {
        x = Integer.parseInt(input[1]);
      }
      switch (cmd) {
        case "add":
          set.add(x);
          break;
        case "remove":
          set.remove(x);
          break;
        case "check":
          sb.append(set.check(x)).append("\n");
          break;
        case "toggle":
          set.toggle(x);
          break;
        case "all":
          set.all();
          break;
        case "empty":
          set.empty();
          break;
      }
    }
    System.out.println(sb);
  }

  public static class MySet {
    private int[] arr;

    public MySet() {
      this.arr = new int[20];
    }

    public void add(int x) {
      this.arr[x- 1] = 1;
    }

    public void remove(int x) {
      this.arr[x - 1] = 0;
    }

    public int check(int x) {
      return this.arr[x - 1];
    }

    public void toggle(int x) {
      this.arr[x - 1] = (this.arr[x - 1] + 1) % 2;
    }

    public void all() {
      Arrays.fill(this.arr, 1);
    }

    public void empty() {
      Arrays.fill(this.arr, 0);
    }

  }
}
