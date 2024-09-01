package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10845 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    MyQueue queue = new MyQueue();
    for (int i = 0; i < n; i++) {
      String[] command = br.readLine().split(" ");
      switch (command[0]) {
        case "push":
          queue.push(Integer.parseInt(command[1]));
          break;
        case "pop":
          bw.write(queue.pop() + "\n");
          break;
        case "size":
          bw.write(queue.size() + "\n");
          break;
        case "empty":
          bw.write(queue.empty() + "\n");
          break;
        case "front":
          bw.write(queue.front() + "\n");
          break;
        case "back":
          bw.write(queue.back() + "\n");
          break;
      }
    }

    bw.flush();
  }

  public static class MyQueue {

    Node front;
    Node back;
    int size;

    public MyQueue() {
      this.front = null;
      this.back = null;
      this.size = 0;
    }

    public void push(int data) {
      Node newNode = new Node(data);
      if (this.size == 0) {
        this.front = newNode;
        this.back = newNode;
      } else {
        this.back.next = newNode;
        this.back = newNode;
      }
      this.size++;
    }

    public int pop() {
      if (this.size == 0) {
        return -1;
      } else {
        int data = this.front.data;
        this.front = this.front.next;
        this.size--;
        return data;
      }
    }

    public int size() {
      return this.size;
    }

    public int empty() {
      if (this.size == 0) {
        return 1;
      } else {
        return 0;
      }
    }

    public int front() {
      if (this.size == 0) {
        return -1;
      } else {
        return this.front.data;
      }
    }

    public int back() {
      if (this.size == 0) {
        return -1;
      } else {
        return this.back.data;
      }
    }
  }

  public static class Node {

    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
}