package com.company.binarytree;

/**
 * 1315. Sum of Nodes with Even-Valued Grandparent
 * Medium
 *
 * Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0.
 *
 * A grandparent of a node is the parent of its parent if it exists.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 18
 * Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
 *
 * Example 2:
 *
 * Input: root = [1]
 * Output: 0
 */

public class SunOfNodesWith_Even_Value_Grandparent {
    int ans;
    public int sumEvenGrandparent(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    void dfs(TreeNode root){
        if(root == null) return;
        if(root.val%2 == 0){
            if(root.left != null){
                TreeNode t = root.left;
                if(t.left != null) ans += t.left.val;
                if(t.right != null) ans += t.right.val;
            }
            if(root.right != null){
                TreeNode t = root.right;
                if(t.left != null) ans += t.left.val;
                if(t.right != null) ans += t.right.val;
            }
        }
        dfs(root.left);
        dfs(root.right);
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
