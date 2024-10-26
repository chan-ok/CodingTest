package study.codingtest.leetcode;

import java.util.Arrays;

public class LC_704 {

//  public int binarySearch(int[] nums, int target, int left, int right) {
//    if (left <= right) {
////      int mid = (left + right) / 2;
//      int mid = left + (right - left) / 2;
//      if (nums[mid] < target) {
//        return binarySearch(nums, target, mid + 1, right);
//      } else if (nums[mid] > target) {
//        return binarySearch(nums, target, left, mid - 1);
//      } else {
//        return mid;
//      }
//    } else {
//      return -1;
//    }
//  }
//
//  public int search(int[] nums, int target) {
//    return binarySearch(nums, target, 0, nums.length - 1);
//  }

//  public int search(int[] nums, int target) {
//    int left = 0, right = nums.length - 1;
//    while (left <= right) {
//      int mid = left + (right - left) / 2;
//      if (nums[mid] < target) {
//        left = mid + 1;
//      } else if (nums[mid] > target) {
//        right = mid - 1;
//      } else {
//        return mid;
//      }
//    }
//    return -1;
//  }

  public int search(int[] nums, int target) {
    int result = Arrays.binarySearch(nums, target);
    return result >= 0 ? result : -1;
  }
}
