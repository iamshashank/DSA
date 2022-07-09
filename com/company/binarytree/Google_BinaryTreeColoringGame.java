package com.company.binarytree;

/**
 * 1145. Binary Tree Coloring Game
 * Medium
 *
 * Two players play a turn based game on a binary tree. We are given the root of this binary tree,
 * and the number of nodes n in the tree. n is odd, and each node has a distinct value from 1 to n.
 *
 * Initially, the first player names a value x with 1 <= x <= n, and the second player names a value y with 1 <= y <= n and y != x.
 * The first player colors the node with value x red, and the second player colors the node with value y blue.
 *
 * Then, the players take turns starting with the first player.
 * In each turn, that player chooses a node of their color (red if player 1, blue if player 2) and colors an uncolored neighbor of the chosen node
 * (either the left child, right child, or parent of the chosen node.)
 *
 * If (and only if) a player cannot choose such a node in this way, they must pass their turn. If both players pass their turn, the game ends,
 * and the winner is the player that colored more nodes.
 *
 * You are the second player. If it is possible to choose such a y to ensure you win the game, return true. If it is not possible, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
 * Output: true
 * Explanation: The second player can choose the node with value 2.
 *
 * Example 2:
 *
 * Input: root = [1,2,3], n = 3, x = 1
 * Output: false
 *
 */

public class Google_BinaryTreeColoringGame {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // the idea is after Player1 choses its 1st node
        // the tree is divided into 3 parts 1. left subtree of X, 2 right subtree of X 3. parent of X and rest
        // each of these 3 section is divided and cannot be crossed over so our option si to choose the largest of the three
        // the remaining 2 will go into Player1 terrritory
        // so out MAX should be > 1 + remaining 2
        TreeNode X = getNode(root, x);
        int left = countNodes(X.left);
        int right = countNodes(X.right);
        int parentAndRest = n - (left + right +1); // +1 because the node which player 1 initially counted is also to be considered

        int max = Math.max(left,Math.max(right, parentAndRest));
        int min = Math.min(left,Math.min(right, parentAndRest));
        int mid = n - (max + min + 1);

        // so our player will choose the max now if its graeter than min + mid + 1 then we win
        return (max > (min + mid + 1)) ? true : false;

    }

    public int countNodes(TreeNode root){
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public TreeNode getNode(TreeNode root, int x){
        if(root == null) return null;
        if(root.val == x) return root;
        TreeNode left = getNode(root.left, x);
        TreeNode right = getNode(root.right, x);
        return (left == null) ? right : left;
    }

    private class TreeNode{
        int val;
        TreeNode right, left;
    }
}
