package com.company.binarytree;


/**
 *https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Basically there are three possible cases for finding the lowest common ancestor
 * Case 1) The nodes P and Q lies on the left side of the root
 * Case 2)The nodes P andQ lies on right side of the root
 * Case 3) The nodes P and Q lies on the either side of the root
 * Approach: We will traverse the tree and look for the Pth node on the left side and Qth node on the right side.
 * If we find P and Q on the left and right side respectively , then we know that the LCA is root.
 * If we find P on the left side and couldnot find Q on the right side then Q must be lying on the left side so for the right side we will return null and the LCA will be P itself.
 * If we find Q on the right side and couldnot find P on the left side then P must be lying on the right side so for the left side we will return null and the LCA will be Q itself.
 * Now you must be wondering what if we find Q on the left side instead of P , To avoid that case we will check if we find any of the two nodes then we will return that node .
 * So it simplifies to:
 * 1)if you get P and Q then root is LCA
 * 2)if you get either of them and other is null , then the not null one will be LCA
 *
 */

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        TreeNode left, right;
        left = lowestCommonAncestor(root.left, p, q); // 5
        right = lowestCommonAncestor(root.right, p, q);
        // if you get from both left & right then root is the LCA
        // else whichever is not null
        if(left != null && right != null)
            return root;
        if(right == null)
            return left;
        return right;
    }

    private class TreeNode {
        public TreeNode left;
        public TreeNode right;
    }
}
