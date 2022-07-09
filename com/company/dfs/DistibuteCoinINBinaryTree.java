package com.company.dfs;


/**
 *
 * 979. Distribute Coins in Binary Tree
 * Medium
 *
 * You are given the root of a binary tree with n nodes where each node in the tree has node.val coins. There are n coins in total throughout the whole tree.
 *
 * In one move, we may choose two adjacent nodes and move one coin from one node to another. A move may be from parent to child, or from child to parent.
 *
 * Return the minimum number of moves required to make every node have exactly one coin.
 *
 * Intuition
 *
 * If the leaf of a tree has 0 coins (an excess of -1 from what it needs), then we should push a coin from its parent onto the leaf. If it has say, 4 coins (an excess of 3), then we should push 3 coins off the leaf. In total, the number of moves from that leaf to or from its parent is excess = Math.abs(num_coins - 1). Afterwards, we never have to consider this leaf again in the rest of our calculation.
 *
 * Algorithm
 *
 * We can use the above fact to build our answer. Let dfs(node) be the excess number of coins in the subtree at or below this node: namely, the number of coins in the subtree, minus the number of nodes in the subtree. Then, the number of moves we make from this node to and from its children is abs(dfs(node.left)) + abs(dfs(node.right)). After, we have an excess of node.val + dfs(node.left) + dfs(node.right) - 1 coins at this node.
 */

public class DistibuteCoinINBinaryTree {
    int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;
        int left = 0, right = 0;
        left = dfs(root.left);
        right = dfs(root.right);
        // we sum up how many changes are needed up till now which will the answer at last
        ans += Math.abs(left) + Math.abs(right);
        // at each node this is number od exchange needed
        return root.val + left + right - 1;
    }

    class TreeNode {
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
