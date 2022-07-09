package com.company.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 *
 * 1443. Minimum Time to Collect All Apples in a Tree
 * Medium
 *
 * Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices. You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend to collect all apples in the tree, starting at vertex 0 and coming back to this vertex.
 *
 * The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi. Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple; otherwise, it does not have any apple.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
 * Output: 8
 * Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.
 */


public class HARD_MinTimeToCollectAllApple {
    int steps = 0;
    HashMap<Integer, List<Integer>> adj;
    List<Boolean> hasApple;
    boolean[] v;
    public int minTime(int n, int[][] edges, List<Boolean> hasApp) {
        adj = new HashMap<>();
        hasApple = hasApp;
        v = new boolean[n];
        Arrays.fill(v, false);
        for(int i= 0;i<n;i++) adj.put(i, new ArrayList<Integer>());
        for(int[] edge :  edges){
            Integer from = edge[0];
            Integer to = edge[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        // System.out.println(adj);
        dfs(0);
        return steps;
    }

    // what we are trying do is after we return from child recursion to parent
    // if we had found a apple in child we return true
    // we keep count of how many child has apple so that we can do 2*NoOfChildThatHadApple
    public boolean dfs(int root){
        v[root] = true;
        int noOfChildWhereAppleFound = 0;
        for(Integer child : adj.get(root)){
            if(!v[child]){
                boolean appleFound = dfs(child);
                if(appleFound) noOfChildWhereAppleFound++;
            }
        }
        steps += (2*noOfChildWhereAppleFound);
        // if this node has apple or its children had apple we will return true so that this path can be fully counted
        if(hasApple.get(root) || noOfChildWhereAppleFound > 0) return true;
        return false;
    }
}
