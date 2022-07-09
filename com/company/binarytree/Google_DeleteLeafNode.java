package com.company.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Google_DeleteLeafNode {
    /**
     * Leetcode 366
     * arr = [1, 2, 3, 4 ,5 ]
     * Removes leaves of a binary tree in layers [ [4, 5, 3], [2], [1] ]
     * follow up: 1. remove new created leaves first (after remove 4,5, we need remove 2 immediately..then 6,7 ....)
     * 1
     * / \
     * 2 3
     * / \ / \
     * 4 5 6 7
     * follow up: 2 remove new created leaves last
     */

    List<List<Integer>> ans;
     int dfsLayer(TreeNode node, int layer){
         // THIS WILL PRINT LEAF LAYER BY LAYER
        if(node == null) return layer;
        int leftLayer = dfsLayer(node.left, layer);
        int rightLayer = dfsLayer(node.right, layer);
        // now increase the layerIndex for the parent
        int max = Math.max(leftLayer, rightLayer);
        if(ans.size() < max+1 ){
            List<Integer> t = new ArrayList<>();
            ans.add(t);
        }
        ans.get(max).add(node.val);
        return max+1;
    }

    List<Integer> ans1;
    // DFS
    void removeLatestLeaf(TreeNode node){
         if(node == null) return;
         removeLatestLeaf(node.left);
         removeLatestLeaf(node.right);
         ans1.add(node.val);
         node.left = null;
         node.right = null;
    }

    void removeOldesstLeaf(TreeNode node){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            TreeNode n = q.remove();
            System.out.println(n.val);
            if(n.left != null) q.add(n.left);
            if(n.right != null) q.add(n.right);
            n = null;
        }
    }

    public void setup(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        ans = new ArrayList<>();
        dfsLayer(root, 0);
        System.out.println(ans);

        // delete latest leaf nodes 1st
        ans1 = new ArrayList<>();
        removeLatestLeaf(root);
        root = null; // delete last node
        System.out.println(ans1);

        // new tree
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // remove latest leaf last so BFS, root is the oldest leaf so remove it first
        removeOldesstLeaf(root);
    }

    private class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }
}
