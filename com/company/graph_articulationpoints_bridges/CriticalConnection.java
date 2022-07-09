package com.company.graph_articulationpoints_bridges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *https://www.youtube.com/watch?v=2kREIkF9UAs
 * 1192. Critical Connections in a Network
 * Hard
 *
 * There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.
 *
 * A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
 *
 * Return all critical connections in the network in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 *
 * Example 2:
 *
 * Input: n = 2, connections = [[0,1]]
 * Output: [[0,1]]
 *
 */

public class CriticalConnection {
    // what we are finding in this question are bridges
    // bridges are edges on removing it the graph breaks into 2 or more component
    boolean[] v;
    int[] disc;
    int[] low;
    HashMap<Integer, List<Integer>> adj;
    List<List<Integer>> ans;
    int clock = 0;
    // bonus
    // we will also store the articulation points
    // articulation points are nodes on removing which the rest of the graph splits into 2 or more disconnected graphs
    List<Integer> articulationPoints;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // this indicate all nodes connected by exactly 1 edge so all are critical
        if(connections.size() == n-1) return connections;

        v = new boolean[n];
        Arrays.fill(v, false);
        // discovery
        disc = new int[n];
        // stores the backedge
        low = new int[n];

        adj = new HashMap<>();
        for(int i= 0;i<n;i++) adj.put(i, new ArrayList<Integer>());
        for(List<Integer> edge :  connections){
            Integer from = edge.get(0);
            Integer to = edge.get(1);
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        ans = new ArrayList<>();
        articulationPoints = new ArrayList<>();

        dfs(0, -1);

        return ans;
    }

    public void dfs(int node, int parent){
        v[node] = true;
        disc[node] = low[node] = clock;
        clock++;

        // go through all child nodes
        for(Integer child : adj.get(node)){
            if(!v[child]){
                dfs(child, node);
                low[node] = Math.min(low[node], low[child]);
                // so what we trying to do in the above statement is after dfs(child) we are hoping that we find a backedge from child to `node` or ancestor of `node`
                // this will result in child having lower low[child] value than parent discovery time
                // but if even after dfs(child) the low[child] is still greater than disc[node] that means no backedge is present and `node` is a articulation node
                if(low[child] > disc[node] ){
                    // then `node` is a articulation node and edge from node -> child is a bridge
                    // root node maybe added multiple times for each of its child so use set to remove duplicate
                    articulationPoints.add(node);
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(node);
                    t.add(child);
                    ans.add(t);
                }
            }else if(child != parent){
                // so this `node` not a articulation point because we found a another path to this node from child
                // agar koi aisa child mila hai joki parent nai hai but visited hai
                // fir hum kosis karenge apne low[node] ko decrease karne ki
                low[node] = Math.min(low[node], low[child]);
            }
        }

    }
}
