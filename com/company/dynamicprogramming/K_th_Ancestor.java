package com.company.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 1483. Kth Ancestor of a Tree Node
 * Hard
 *
 * You are given a tree with n nodes numbered from 0 to n - 1 in the form of a parent array parent where parent[i] is the parent of ith node. The root of the tree is node 0. Find the kth ancestor of a given node.
 *
 * The kth ancestor of a tree node is the kth node in the path from that node to the root node.
 *
 * Implement the TreeAncestor class:
 *
 *     TreeAncestor(int n, int[] parent) Initializes the object with the number of nodes in the tree and the parent array.
 *     int getKthAncestor(int node, int k) return the kth ancestor of the given node node. If there is no such ancestor, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["TreeAncestor", "getKthAncestor", "getKthAncestor", "getKthAncestor"]
 * [[7, [-1, 0, 0, 1, 1, 2, 2]], [3, 1], [5, 2], [6, 3]]
 * Output
 * [null, 1, 0, -1]
 *
 * Explanation
 * TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
 * treeAncestor.getKthAncestor(3, 1); // returns 1 which is the parent of 3
 * treeAncestor.getKthAncestor(5, 2); // returns 0 which is the grandparent of 5
 * treeAncestor.getKthAncestor(6, 3); // returns -1 because there is no such ancestor
 *
 */

// https://www.youtube.com/watch?v=oib-XsjFa-M

public class K_th_Ancestor {

    // BRUTE FORCE WITH SPARCE MATRIX TO SAVE SPACE
//    List<List<Integer>> dp;
//    public K_th_Ancestor(int n, int[] p) {
//        dp = new ArrayList<>();
//        for(int i =0;i<n;i++){
//            dp.add(new ArrayList<Integer>());
//        }
//        for(int i=0;i<n;i++) dp.get(i).add(i);
//        dp.get(0).add(-1);
//        for(int i=1;i<n;i++) dp.get(i).add(p[i]);
//
//        for(int i=0;i<n;i++){
//            for(int j =2;j<n;j++){
//                if(dp.get(i).get(j-1) == -1) break;
//                dp.get(i).add(p[dp.get(i).get(j-1)]);
//            }
//        }
//        // for(int i =0;i<n;i++){
//        //     System.out.println(dp.get(i));
//        // }
//    }
//
//    public int getKthAncestor(int node, int k) {
//        if(k>dp.get(node).size()-1) return -1;
//        return dp.get(node).get(k);
//    }
//


    // BRUTE FORCE
//    int[][] dp;
//    public K_th_Ancestor(int n, int[] p) {
//        dp = new int[n+1][n+1];
//        for(int i =0;i<n;i++){
//            Arrays.fill(dp[i], -1);
//        }
//        for(int i=0;i<n;i++) dp[i][0] = i;
//        for(int i=0;i<n;i++) dp[i][1] = p[i];
//
//        for(int i=0;i<n;i++){
//            for(int j =2;j<n+1;j++){
//                if(dp[i][j-1] == -1) break;
//                dp[i][j] = (dp[i][j-1] == -1) ? -1 : p[dp[i][j-1]];
//            }
//        }
//        // for(int i =0;i<n;i++){
//        //     System.out.println(dp.get(i));
//        // }
//    }
//
//    public int getKthAncestor(int node, int k) {
//        return dp[node][k];
//    }

    int[][] dp;
    int height;
    // https://www.youtube.com/watch?v=oib-XsjFa-M
    public K_th_Ancestor(int n, int[] p) {
        height = (int) Math.ceil(Math.log(n)/Math.log(2));
        dp = new int[n][height+1];
        for(int j=0; j<n;j++) Arrays.fill(dp[j], -1);
        for(int j=0; j<n;j++) dp[j][0] = p[j]; // j = 0 means 2^0 = 1 or 1st ancestor

        // we are precalculating 2^1 = 2nd ancestor for all nodes then 2^2 = 4th ancestor of all nodes, then 8th
        // we will only precompute 2^ith ancestors for each and rest we will calculate onl fly
        for(int i=1;i<=height;i++){
            for(int node=0; node<n;node++){
                // if j = 3 meaning we are trying to find out 2^3 8th ancestor
                // and since we have j-1 = 2 value which represent the previous most ancestor (2^2 = 4th ancestor) we have till now
                int prevMostAncestor = dp[node][i-1];
                if(prevMostAncestor != -1) dp[node][i] = dp[prevMostAncestor][i-1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for(int pos=0;pos<=height;pos++){
            // since we need to check bits which are 1 in its binary representation
            int i = k & (1 << pos);
            if(i != 0){
                node = dp[node][pos];
                if(node == -1) return -1;
            }
        }
        return node;
    }

}
