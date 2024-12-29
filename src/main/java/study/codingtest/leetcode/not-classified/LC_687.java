package study.codingtest.leetcode;

public class LC_687 {

  int result = 0;

  public int longestUnivaluePath(TreeNode root) {
    dfs(root);
    return this.result;
  }

  public int dfs(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int left = dfs(node.left);
    int right = dfs(node.right);

    if (node.left != null && node.left.val == node.val) {
      left += 1;
    } else {
      left = 0;
    }

    if (node.right != null && node.right.val == node.val) {
      right += 1;
    } else {
      right = 0;
    }

    this.result = Math.max(this.result, left + right);
    return Math.max(left, right);
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
