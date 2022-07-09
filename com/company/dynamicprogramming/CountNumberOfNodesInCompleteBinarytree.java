package com.company.dynamicprogramming;

import java.util.HashMap;

public class CountNumberOfNodesInCompleteBinarytree {
    HashMap<TreeNode, Integer> map;
    public int countNodes(TreeNode root) {
        map = new HashMap<>();
        if(root == null) return 0;
        recursiveCount(root);
        return map.get(root);
    }

    public int recursiveCount(TreeNode root){
        if(root == null)
            return 0;
        if(map.containsKey(root))
            return map.get(root);
        int c = 1 +  recursiveCount(root.left) + recursiveCount(root.right);
        map.put(root, c);
        return c;
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
