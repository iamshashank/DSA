package com.company.binarytree;

import com.company.bfs.FindNumberOfNodeAtEachDepth;

/**
 *https://leetcode.com/problems/binary-tree-cameras/
 *
 * 968. Binary Tree Cameras
 * Hard
 *
 * You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.
 *
 * Return the minimum number of cameras needed to monitor all nodes of the tree.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [0,0,null,0,0]
 * Output: 1
 * Explanation: One camera is enough to monitor all nodes if placed as shown.
 *
 */

public class AddCamera {
    final int MONITERED = 1; // no camera at this node but its under a camera
    final int NOT_MONITERED = 2; // it not under any of the camera
    final int CAMERA = 3; // camera at this node
    int count = 0;

    public int minCameraCover(TreeNode root) {
        return process(root) == NOT_MONITERED ? count + 1: count;
    }

    // isme main trick ye hai ki isme node[i] apne parent ko apna status send kar hai
    // like if at a node i, if its children are monitered then node i will tell its perent (return its status) its status
    public int process(TreeNode root){
        if(root == null)
            return MONITERED;
        int left = process(root.left);
        int right = process(root.right);
        if(left == NOT_MONITERED || right == NOT_MONITERED){
            count++;
            return CAMERA; // if none of the child is monitered then we need to add camera to node and and tell this to the above node
        }else if(left == CAMERA || right == CAMERA){
            return MONITERED; // if there is camera on any child then parent is monitered
        }else{
            // any one monitered then tell the parent the this node is not monitered
            return NOT_MONITERED;
        }
    }
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
}
