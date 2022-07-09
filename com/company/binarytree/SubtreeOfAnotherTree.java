package com.company.binarytree;

import java.util.ArrayList;

/**
 *
 *
 * 572. Subtree of Another Tree
 * Easy
 *
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 *
 * Example 2:
 *
 * Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * Output: false
 *
 */

public class SubtreeOfAnotherTree {
    ArrayList<TreeNode> target;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        target = new ArrayList<>();
        locateSubRoot(root, subRoot);
        if (target.isEmpty()) {
            return false;
        }
        String inorderSubRoot = inorder(subRoot);
        // System.out.println(inorderSubRoot);
        for (TreeNode t : target) {
            String inorderRoot = inorder(t);
            // System.out.println(inorderRoot);
            if (inorderRoot.equals(inorderSubRoot)) return true;
        }
        return false;
    }

    public void locateSubRoot(TreeNode root, TreeNode t) {
        if (root == null) return;
        if (root.val == t.val) {
            target.add(root);
        }
        locateSubRoot(root.left, t);
        locateSubRoot(root.right, t);
    }

    public String inorder(TreeNode root) {
        if (root == null) return "#";
        return root.val + "" + inorder(root.left) + "" + inorder(root.right);
    }

    private class TreeNode {
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
