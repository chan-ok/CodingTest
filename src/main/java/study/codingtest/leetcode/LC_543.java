package study.codingtest.leetcode;

public class LC_543 {

  int longest = 0;

  public int dfs(TreeNode node) {
    if (node == null) {
      return -1;
    }
    int left = dfs(node.left);
    int right = dfs(node.right);
    this.longest = Math.max(this.longest, left + right + 2);
    return Math.max(left, right) + 1;
  }

  public int diameterOfBinaryTree(TreeNode root) {
    dfs(root);
    return this.longest;
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
