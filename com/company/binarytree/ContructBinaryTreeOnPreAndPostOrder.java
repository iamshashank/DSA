package com.company.binarytree;

import java.util.HashMap;

/**
 *https://www.youtube.com/watch?v=5lWJpTEnyow
 *
 *
 889. Construct Binary Tree from Preorder and Postorder Traversal
 Medium

 Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.

 If there exist multiple answers, you can return any of them.



 Example 1:

 Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 Output: [1,2,3,4,5,6,7]
 */

public class ContructBinaryTreeOnPreAndPostOrder {
    HashMap<Integer, Integer> postMap, preMap;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int l = preorder.length;
        postMap = new HashMap<>();
        preMap  = new HashMap<>();
        // preorder =  [1,2,4,5,3,6,7] ROOT, LEFT,  RIGHT
        // postorder = [4,5,2,6,7,3,1] LEFT, RIGHT, ROOT
        // so in preorder index 0 is the roor and in postorder index L is the root
        // we need index of elements in postorder for quick access
        for(int i = 0;i<postorder.length;i++){
            postMap.put(postorder[i], i);
            preMap.put(preorder[i], i);
        }
        TreeNode root = process(preorder, postorder, 0, l-1, 0, l-1);
        return root;
    }

    public TreeNode process(int[] pre, int[] post, int preLow, int preHigh, int postLow, int postHigh){
        if(preLow > preHigh || postLow > postHigh){
            return null;
        }

        TreeNode main = new TreeNode(pre[preLow]);
        if(preLow + 1 <= preHigh){
            // for the elements in the next left subtree we find the pos of pre[preLow+1] in postorder
            int leftSubTreeKaRootInPostOrder = postMap.get(pre[preLow+1]);
            int noOfElInLeftSubTree = leftSubTreeKaRootInPostOrder - postLow + 1;

            main.left  = process(pre, post, preLow+1, preLow+noOfElInLeftSubTree, postLow, leftSubTreeKaRootInPostOrder);
            main.right = process(pre, post, preLow+noOfElInLeftSubTree+1, preHigh, leftSubTreeKaRootInPostOrder+1, postHigh-1);
        }
        return main;
    }

    private class TreeNode{
        TreeNode left, right;
        int val;
        TreeNode(int val){
            this.val = val;
        }
    }
}