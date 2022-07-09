package com.company.dijakstra_single_source_shortest_path;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. All Paths From Source to Target
 * Medium
 *
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 *
 *
 *
 * Example 1:
 *
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 */

public class AllPathFromSourceToTarget {
    int[][] adj;
    int n;
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        adj = graph;
        ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, path);
        return ans;
    }

    void dfs(int node, List<Integer> path){
        if(node == n-1){
            List<Integer> cpy = new ArrayList<>();
            for(int x : path) cpy.add(x);
            ans.add(cpy);
            return;
        }
        // DAG so no loop and no need for visited array
        for(int i : adj[node]){
            path.add(i);
            dfs(i, path);
            // backtrack
            path.remove(path.size()-1);
        }
    }
}
