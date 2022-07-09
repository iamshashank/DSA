package com.company.binarytree;

/**
 * 543. Diameter of Binary Tree
 * Easy
 *
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Example 2:
 *
 * Input: root = [1,2]
 * Output: 1
 */

public class DiameterOfBinaryTree {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        process(root);
        return ans;
    }

    int process(TreeNode root){
        if(root == null) return 0;
        int l = 0, r = 0;
        if(root.left != null){
            l = 1 + process(root.left);
        }
        if(root.right != null){
            r = 1 + process(root.right);
        }
        ans = Math.max(ans, l+r);
        return Math.max(l,r);
    }

    private class TreeNode{
        TreeNode left, right;
    }
}
