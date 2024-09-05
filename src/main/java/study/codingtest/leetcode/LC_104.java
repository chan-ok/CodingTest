package study.codingtest.leetcode;

public class LC_104 {

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    return Math.max(left, right) + 1;
  }

//  public int maxDepth(TreeNode root) {
//    if (root == null) {
//      return 0;
//    }
//    Queue<TreeNode> queue = new LinkedList<>();
//    queue.offer(root);
//    int depth = 0;
//    while (!queue.isEmpty()) {
//      depth += 1;
//      int qSize = queue.size();
//      for (int i = 0; i < qSize; i++) {
//        TreeNode cur = queue.poll();
//        if (cur.left != null) {
//          queue.offer(cur.left);
//        }
//        if (cur.right != null) {
//          queue.offer(cur.right);
//        }
//      }
//    }
//    return depth;
//  }


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
