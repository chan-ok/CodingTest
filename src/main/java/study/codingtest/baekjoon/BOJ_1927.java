package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1927 {

//  public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int n = Integer.parseInt(br.readLine());
//    Queue<Integer> pq = new PriorityQueue<>();
//    for (int i = 0; i < n; i++) {
//      int x = Integer.parseInt(br.readLine());
//      if (x == 0) {
//        int value = Optional.ofNullable(pq.poll()).orElse(0);
//        System.out.println(value);
//      } else {
//        pq.offer(x);
//      }
//    }
//  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    MyHeap heap = new MyHeap();

    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(br.readLine());
      if (x == 0) {
        System.out.println(heap.extract());
      } else {
        heap.insert(x);
      }
    }
  }

  public static class MyHeap {

    private final List<Integer> arr;

    public MyHeap() {
      this.arr = new ArrayList<>();
      this.arr.add(null);
    }

    public void insert(int k) {
      this.arr.add(k);
      percolateUp();
    }

    private void percolateUp() {
      int idx = arr.size() - 1;
      int parentIdx = idx / 2;

      while (parentIdx > 0) {
        if (arr.get(idx) < arr.get(parentIdx)) {
          swap(idx, parentIdx);
        }
        idx = parentIdx;
        parentIdx = idx / 2;
      }
    }

    public int extract() {
      if (arr.size() == 1) {
        return 0;
      }
      int extracted = arr.get(1);

      arr.set(1, arr.get(arr.size() - 1));
      arr.remove(arr.size() - 1);
      minHeapify(1);

      return extracted;
    }

    private void minHeapify(int i) {
      int left = i * 2;
      int right = i * 2 + 1;
      int smallest = i;

      if (left <= arr.size() - 1 && arr.get(left) < arr.get(smallest)) {
        smallest = left;
      }
      if (right <= arr.size() - 1 && arr.get(right) < arr.get(smallest)) {
        smallest = right;
      }
      if (smallest != i) {
        swap(smallest, i);
        minHeapify(smallest);
      }

    }

    private void swap(int i, int j) {
      int temp = arr.get(i);
      arr.set(i, arr.get(j));
      arr.set(j, temp);
    }

  }
}
