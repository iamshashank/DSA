package com.company.binarytree;

public class Hard_MathPathSum {
    int max;
    public int maxPathSum(TreeNode root) {
        max = root.val;
        dfs(root);
        return max;
    }

    /**
     * In this at every node (every node is a root if its sub-tree) there is 3 option
     * 1. Max sum path is on left sub-tree
     * 2. Max sum path is on right sum tree
     * 3. Math sum path goes root 1 or more elements on left tree + root + 1 or more from right
     */
    int dfs(TreeNode node){
        if(node == null) return 0;

        // incase the sun is -ive we ignore that path
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        max = Math.max(max, node.val+left+right); // THIS IS CHECKING THE 3rd case

        return node.val+Math.max(left, right); // THIS WILL SOLVE 1, 2 case
    }

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

}
