package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10866 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    MyDeque deque = new MyDeque(n);
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      switch (st.nextToken()) {
        case "push_front":
          deque.push_front(Integer.parseInt(st.nextToken()));
          break;
        case "push_back":
          deque.push_back(Integer.parseInt(st.nextToken()));
          break;
        case "front":
          bw.write(String.valueOf(deque.front()) + "\n");
          break;
        case "pop_front":
          bw.write(String.valueOf(deque.pop_front()) + "\n");
          break;
        case "back":
          bw.write(String.valueOf(deque.back()) + "\n");
          break;
        case "pop_back":
          bw.write(String.valueOf(deque.pop_back()) + "\n");
          break;
        case "size":
          bw.write(String.valueOf(deque.size()) + "\n");
          break;
        case "empty":
          bw.write(String.valueOf(deque.empty()) + "\n");
          break;
      }
    }

    bw.flush();
  }

  public static class MyDeque {

    private final int[] array;
    private int size;
    private int front;
    private int back;

    public MyDeque(int n) {
      this.array = new int[n];
      this.size = 0;
      this.front = 1;
      this.back = 0;
    }

    public void push_back(int value) {
      this.array[(this.array.length + ++this.back) % this.array.length] = value;
      this.size++;
    }

    public void push_front(int value) {
      this.array[(this.array.length + --this.front) % this.array.length] = value;
      this.size++;
    }

    public int pop_back() {
      if (this.size == 0) {
        return -1;
      }
      int value = back();
      this.back--;
      this.size--;
      return value;
    }

    public int back() {
      if (this.size == 0) {
        return -1;
      }
      return this.array[(this.array.length + this.back) % this.array.length];
    }

    public int pop_front() {
      if (this.size == 0) {
        return -1;
      }
      int value = front();
      this.front++;
      this.size--;
      return value;
    }

    public int front() {
      if (this.size == 0) {
        return -1;
      }
      return this.array[(this.array.length + this.front) % this.array.length];
    }

    public int size() {
      return this.size;
    }

    public int empty() {
      return this.size == 0 ? 1 : 0;
    }
  }
}
