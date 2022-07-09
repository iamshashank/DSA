package com.company.binarytree;

/**
 *
 * 951. Flip Equivalent Binary Trees
 * Medium
 *
 * For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.
 *
 * A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.
 *
 * Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivalent or false otherwise.
 *
 *
 *
 * Example 1:
 * Flipped Trees Diagram
 *
 * Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
 * Output: true
 * Explanation: We flipped at nodes with values 1, 3, and 5.
 *
 * Example 2:
 *
 * Input: root1 = [], root2 = []
 * Output: true
 *
 * Example 3:
 *
 * Input: root1 = [], root2 = [1]
 * Output: false
 *
 */

public class Google_FlipEquivalentBinarytree {
    boolean ans = true;
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        dfs(root1, root2);
        return ans;
    }

    // we iterate the sane path in both tree symultanioulsy and if we find a diff we swap nodes
    void dfs(TreeNode r1, TreeNode r2){

        if(r1 == null && r2 == null) return;
        if((r1 == null && r2 != null) || (r1 != null && r2 == null)){
            // this means length not equal
            ans = false;
            return;
        }
        // System.out.println(r1.val + " " +r2.val);
        if(r1.val != r2.val){
            ans = false;
            return;
        }else{
            if(r1.left != null && r2.left != null && r1.left.val != r2.left.val ){
                TreeNode t = r1.left;
                r1.left = r1.right;
                r1.right = t;
            }else if((r1.left != null && r2.left == null) || (r1.left == null && r2.left != null) ){
                TreeNode t = r1.left;
                r1.left = r1.right;
                r1.right = t;
            }else if((r1.right != null && r2.right == null) || (r1.right == null && r2.right != null)){
                TreeNode t = r1.left;
                r1.left = r1.right;
                r1.right = t;
            }
            dfs(r1.left,r2.left);
            dfs(r1.right, r2.right);
        }
    }

    private class TreeNode{
        int val;
        TreeNode right, left;
    }

    /**
     * This is a more cleaner version
     *
     * @param root1
     * @param root2
     * @return
     */

    boolean solve(TreeNode root1, TreeNode root2) {

        if(root1==null && root2==null) {
            return true;
        }

        if(root1==null || root2==null) {
            return false;
        }

        boolean result1 = solve(root1.left, root2.left) && solve(root1.right, root2.right);
        boolean result2 = solve(root1.left, root2.right) && solve(root1.right, root2.left);

        return root1.val == root2.val && (result1 | result2);
    }

    public boolean flipEquivCleaner(TreeNode root1, TreeNode root2) {
        return solve(root1, root2);
    }

}
