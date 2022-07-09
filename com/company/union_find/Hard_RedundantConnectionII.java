package com.company.union_find;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=d0tqBMRZ6UQ
 *
 * 685. Redundant Connection II
 * Hard
 *
 * In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.
 *
 * The given input is a directed graph that started as a rooted tree with n nodes (with distinct values from 1 to n), with one additional directed edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.
 *
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [ui, vi] that represents a directed edge connecting nodes ui and vi, where ui is a parent of child vi.
 *
 * Return an edge that can be removed so that the resulting graph is a rooted tree of n nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.
 *
 *
 *
 * Example 1:
 *
 * Input: edges = [[1,2],[1,3],[2,3]]
 * Output: [2,3]
 *
 * Example 2:
 *
 * Input: edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
 * Output: [4,1]
 *
 *
 *
 * Constraints:
 *
 *     n == edges.length
 *     3 <= n <= 1000
 *     edges[i].length == 2
 *     1 <= ui, vi <= n
 *     ui != vi
 */

public class Hard_RedundantConnectionII {
    int[] parent, rank;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        // IN this question only 1 extra edge is added so there are 3 situations possible
        // Case 1 A node has 2 parent indegree = 2, no cycle
        // case 2 Every node has 1 parent but there is a cycle
        // Case 3 There is node with 2 parent + there is a cycle

        // indegree calculation
        int[] indegree = new int[n+1];
        // we need to fill -1 because we will e tracking index which can be 0 and above
        Arrays.fill(indegree, -1);
        int edgeIndex1 = -1, edgeIndex2 = -1;

        for(int i=0;i<n;i++){
            int v = edges[i][1];
            if(indegree[v] == -1){
                indegree[v] = i;
            }else{
                edgeIndex1 = indegree[v];
                edgeIndex2 = i;
            }
        }
        // System.out.println(Arrays.toString(indegree));
        // System.out.println(edgeIndex1+ " " +edgeIndex2);

        // if there is no cycle CASE-1 then edgeIndex2 is answer as it occure last
        // CASE 2: if there is only cycle and no edge with indegree 2 then which ever edge forms the cycle parent(1) == parent(2)
        // if there is cycle + indegree > 2 then among edgeIndex2. edgeIndex1 whichever is the part of the cycle is the answer
        // to find out we assume edgeIndex2 is the answer as it occure later in edges campared to edgeIndex1
        // we skip this edge and do union of the remaining edges
        // if find a cycle (parent(u) == parent(v)) edgeIndex1 = edgeIndex2 = -1

        for(int i =0;i<n;i++){
            if(i == edgeIndex2) continue;

            int u = edges[i][0];
            int v = edges[i][1];
            if(parent(u) == parent(v)){
                // cycle found
                if(edgeIndex1 == -1){
                    // Case 2
                    return edges[i]; // this is causing cycle
                }else{
                    // we assumend that if indegree is 2 then edgeIndex2 will be part of the cycle so we skipped it at the beginning of the loop
                    // but we still found the loop so edgeIndex2 was not part of the loop and is not the answer
                    return edges[edgeIndex1];
                }
            }else{
                union(u,v);
            }
        }
        return edges[edgeIndex2]; /// case 3
    }

    int parent(int node){
        if(node == parent[node]) return node;
        return parent(parent[node]);
    }

    void union(int a, int b){
        a = parent(a);
        b = parent(b);
        if(b > a){
            parent[a] = b;
            rank[b]++;
        }else{
            parent[b] = a;
            rank[a]++;
        }
    }
}
