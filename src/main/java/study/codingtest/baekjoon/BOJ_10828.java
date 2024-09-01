package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10828 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    MyStack stack = new MyStack(n);
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      String operation = input[0];
      switch (operation) {
        case "push":
          stack.push(Integer.parseInt(input[1]));
          break;
        case "pop":
          bw.write(stack.pop() + "\n");
          break;
        case "size":
          bw.write(stack.size() + "\n");
          break;
        case "empty":
          bw.write(stack.empty() + "\n");
          break;
        case "top":
          bw.write(stack.top() + "\n");
          break;
        default:
          break;
      }
    }
    bw.flush();
  }

  public static class MyStack {

    private final int[] stack;
    private int size;

    public MyStack(int stackSize) {
      stack = new int[stackSize];
      size = 0;
    }

    public void push(int value) {
      stack[size++] = value;
    }

    public int pop() {
      return size == 0 ? -1 : stack[--size];
    }

    public int empty() {
      return size == 0 ? 1 : 0;
    }

    public int top() {
      return this.size == 0 ? -1 : stack[size - 1];
    }

    public int size() {
      return this.size;
    }

  }
}