package study.codingtest.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_783 {

  public int minDiffInBST(TreeNode root) {
    int prev = Integer.MIN_VALUE + 100_000;
    int minDiff = Integer.MAX_VALUE;

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode node = root;

    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      node = stack.pop();

      minDiff = Math.min(minDiff, node.val - prev);
      prev = node.val;
      node = node.right;
    }
    return minDiff;
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

}
