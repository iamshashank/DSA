package com.company.binarytree;

import java.util.HashMap;

// SIMILAR TO `Hard_MathPathSum`
public class Google_MaxSumPathOf_K_Length {
    HashMap<TreeNode, Integer> dp;
    public void setup(){
        dp = new HashMap<>();
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        System.out.println(maxPathSumK(root, 2));
        System.out.println(maxPathSumK(root, 3));
        System.out.println(maxPathSumK(root, 1));
    }

    /**
     * In this at every node (every node is a root if its sub-tree) there is 3 option
     * 1. Max sum path is on left sub-tree
     * 2. Max sum path is on right sum tree
     * 3. Math sum path goes root 1 or more elements on left tree + root + 1 or more from right
     */
    int maxPathSumK(TreeNode node, int k){
        if(node == null) return Integer.MIN_VALUE;
        int ans = Math.max( maxPathSumK(node.left, k), maxPathSumK(node.right, k) );
        for(int i=0;i<k;i++){
            // we divide k elements between left and right subtree + 1 for root
            int left = maxPathK(node.left, i);
            int right = maxPathK(node.right, k-1-i);
            int t = node.val+right+left;
            if(left == Integer.MIN_VALUE || right == Integer.MIN_VALUE){
                t = Integer.MIN_VALUE; // to protect from case were node.val is -ive
            }
            ans = Math.max(ans, t);
        }
        return ans;
    }

    int maxPathK(TreeNode node, int k){
        if(k == 0) return 0;
        if(node == null) return Integer.MIN_VALUE;
        int left = maxPathK(node.left, k-1);
        int right = maxPathK(node.right, k-1);
        int sum = 0;
        if(left == Integer.MIN_VALUE || right == Integer.MIN_VALUE){
            sum = Integer.MIN_VALUE;
        }else{
            sum = node.val + Math.max(left, right);
        }
        return sum;
    }

    class TreeNode{
        int val;
        TreeNode left = null, right = null;
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
