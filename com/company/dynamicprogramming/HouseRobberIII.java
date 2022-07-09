package com.company.dynamicprogramming;

import java.util.HashMap;

/**
 * 337. House Robber III
 * Medium
 *
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 *
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 *
 * Example 2:
 *
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */

public class HouseRobberIII {
    HashMap<TreeNode, Integer[]> v;
    public int rob(TreeNode root) {
        v = new HashMap<>();
        return dfs(root, 0);
    }

    int dfs(TreeNode node, int robbed){
        if(node == null) return 0;
        Integer[] dp = v.get(node);
        if(dp != null && dp[robbed] != -1) return dp[robbed];

        if(dp == null){
            dp = new Integer[]{-1,-1};
        }

        int max = Integer.MIN_VALUE;

        if(robbed == 1){
            // we have to skip this one
            max = Math.max(max, dfs(node.left, 0)+dfs(node.right, 0));
        }else{
            // now we can rob or skip
            // rob the current
            max = Math.max(max, node.val+ dfs(node.left, 1)+dfs(node.right, 1));
            // skip the current
            max = Math.max(max, dfs(node.left, 0) + dfs(node.right, 0));
        }

        dp[robbed] = max;
        v.put(node, dp);
        return max;
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
