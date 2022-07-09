package com.company.binarytree;

import java.util.*;

/**
 *
 * 310. Minimum Height Trees
 * Medium
 *
 * A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
 *
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
 *
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 *
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, edges = [[1,0],[1,2],[1,3]]
 * Output: [1]
 * Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
 *
 * Example 2:
 *
 * Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * Output: [3,4]
 *
 */

public class MinimumHeightTree_Centroid {


    /**
     *
     * https://leetcode.com/problems/minimum-height-trees/solution/
     *
     * see the solution tab for the explanation
     *
     * @param n
     * @param edges
     * @return
     */

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // apply bst from each node but that is inefficient
        // so use the centroid approach

        // base case
        if(n < 2){
            ArrayList<Integer> r = new ArrayList<Integer>();
            for(int i =0;i<n;i++) r.add(i);
            return r;
        }

        // in the centroid logic there can be max 2 centroid in the tree if height is even and 1 of height is odd
        HashMap<Integer, Integer> map =new HashMap<>();
        // store min height
        int min= Integer.MAX_VALUE;
        // create the adjacenecy matrix
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        // store how many edges are from each node which will tell the leaf nodes where indgree = 1
        int[] indegree = new int[n];
        for(int[] edge : edges){
            ArrayList<Integer> t1 = adj.getOrDefault(edge[0], new ArrayList<Integer>());
            ArrayList<Integer> t2 = adj.getOrDefault(edge[1], new ArrayList<Integer>());
            t1.add(edge[1]);
            t2.add(edge[0]);

            adj.put(edge[0], t1);
            adj.put(edge[1], t2);

            // trick to find the all lead node when traversing edges
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        // run bfs from from all leaf node toward center so put all leaf node in queue
        for(int i=0;i<n;i++){
            if(indegree[i] == 1) q.add(i);
        }

        // since there can only be 2 centroid we stop when we reach below 3
        while(n>2){
            // we will iterate 1 level at a time
            // this way we remove same distance nodes from centroid
            int l = q.size();
            n -= l;
            while(l>0){
                int node = q.remove();
                indegree[node]--;
                // we are using indegree array so we dont need to do all this
                // since it was leaf it only had one edge connecting to its parent
                // int parentOfLeaf = adj.get(node).get(0);
                // adj.get(parentOfLeaf).remove(node); // remove connection from parent
                // adj.remove(node); // remove this node from adjacency matrix
                // END (we are using indegree array so we dont need to do all this)
                for(Integer child : adj.get(node)){
                    // since we remoce the leaf we need to reduce indegree by 1 for all its connected nodes
                    indegree[child]--;
                    if(indegree[child] == 1){
                        // now this is a new leaf
                        q.add(child);
                    }
                }
                l--;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.remove());
        }

        return ans;
    }

}
