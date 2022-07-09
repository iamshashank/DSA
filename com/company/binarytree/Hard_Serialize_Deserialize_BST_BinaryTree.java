package com.company.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree OR Binary Search Tree (BST)
 * Hard
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 *
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 104].
 *     -1000 <= Node.val <= 1000
 */
public class Hard_Serialize_Deserialize_BST_BinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        String s = "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        s += root.val+",";
        // BFS
        while(!q.isEmpty()){
            TreeNode parent = q.remove();
            if(parent.left != null){
                q.add(parent.left);
                s += parent.left.val+",";
            }else{
                s += "#,";
            }
            if(parent.right != null){
                q.add(parent.right);
                s += parent.right.val+",";
            }else{
                s += "#,";
            }
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "" || data == null) return null;
        String[] arr = data.split(",");
        // System.out.println(Arrays.toString(arr));
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i =1;

        // BFS
        while(i < arr.length){
            TreeNode p = q.remove();
            String el = arr[i++];
            p.left = (el.equals("#")) ? null : new TreeNode(Integer.valueOf(el));
            el = arr[i++];
            p.right = (el.equals("#")) ? null : new TreeNode(Integer.valueOf(el));

            if(p.left != null) q.add(p.left);
            if(p.right != null) q.add(p.right);
        }
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }
}
