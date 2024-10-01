package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14719 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String ignore = br.readLine();
    int[] height = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

    int volume = 0;
    int left = 0;
    int right = height.length - 1;
    int leftMax = height[left];
    int rightMax = height[right];

    while (left < right) {
      leftMax = Integer.max(height[left], leftMax);
      rightMax = Integer.max(height[right], rightMax);

      if (leftMax <= rightMax) {
        volume += leftMax - height[left];
        left++;
      } else {
        volume += rightMax - height[right];
        right--;
      }
    }
    System.out.println(volume);
  }

}
