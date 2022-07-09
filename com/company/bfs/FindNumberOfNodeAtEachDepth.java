package com.company.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindNumberOfNodeAtEachDepth {
    ArrayList<Integer> dp = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    public List<Integer> minCameraCover(TreeNode root) {
        // in this we will run a bfs and store find out how many levels are there and at each level how many nodes are there
        // then we will just find min(nodes at even pos, nodes at odd pos)
        // dp[i] will store number od nodes at depth i
        bfs(root);
        return dp;
    }

    public void bfs(TreeNode root){
        q.add(root);
        dp.add(1); // 1 nodes at level 0
        while(q.size()>0){
            int l = q.size();
            int count = 0;
            for(int i =0;i<l;i++){
                TreeNode node = q.remove();
                if(node.right != null){
                    q.add(node.right);
                    count++;
                }
                if(node.left != null){
                    q.add(node.left);
                    count++;
                }
            }
            // level changes here so
            if(count>0)
                dp.add(count);
        }
    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
}
