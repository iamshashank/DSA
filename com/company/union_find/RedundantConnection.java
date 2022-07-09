package com.company.union_find;

/**
 * 684. Redundant Connection
 * Medium
 *
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
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
 * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
 * Output: [1,4]
 *
 *
 *
 * Constraints:
 *
 *     n == edges.length
 *     3 <= n <= 1000
 *     edges[i].length == 2
 *     1 <= ai < bi <= edges.length
 *     ai != bi
 *     There are no repeated edges.
 *     The given graph is connected.
 */
public class RedundantConnection {
    int[] parent, rank;
    public int[] findRedundantConnection(int[][] edges) {
        // since here its undirected we dont need to worry about indegree
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(parent(u) == parent(v)) return edge;
            union(u,v);
        }
        return edges[n-1];
    }

    int parent(int node){
        if(node == parent[node]) return node;
        return parent(parent[node]);
    }

    void union(int a, int b){
        a = parent(a);
        b = parent(b);
        if(b>a){
            parent[b] = a;
            rank[b]++;
        }else{
            parent[a] = b;
            rank[a]++;
        }
    }
}
