package com.company.binarytree;

import java.util.ArrayList;
import java.util.List;


/**
 * 95. Unique Binary Search Trees II
 * Medium
 *
 * Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 */


public class Hard_GenerateUniqueBST {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    List<TreeNode> helper(int s, int e){
        List<TreeNode> ans = new ArrayList<>();
        if(s > e) {
            ans.add(null);
            return ans;
        }

        for(int i =s;i<=e;i++){
            // so here when root is `i` we get an array of all possible roots of all possible left subtree
            List<TreeNode> left = helper(s, i-1);
            // so here when root is `i` we get an array of all possible roots of all possible right subtree
            List<TreeNode> right = helper(i+1, e);

            // since we have all possible roots from left and right we now make all possible combo of it
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode t = new TreeNode(i, l , r);
                    ans.add(t);
                }
            }
        }

        return ans;
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
