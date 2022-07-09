package com.company.bfs;

import java.util.*;

/**
 * 1319. Number of Operations to Make Network Connected
 * Medium
 *
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.
 *
 * You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.
 *
 * Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, connections = [[0,1],[0,2],[1,2]]
 * Output: 1
 * Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
 *
 * Example 2:
 *
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * Output: 2
 *
 * Example 3:
 *
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * Output: -1
 * Explanation: There are not enough cables.
 */

public class Google_OperationToMakeNetworkConnected {
    boolean[] v;
    HashMap<Integer, List<Integer>> adj;
    public int makeConnected(int n, int[][] connections) {
        adj = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        // fill adjacency matrix
        for(int i=0;i<n;i++) adj.put(i, new ArrayList<>());
        for(int[] c : connections){
            List<Integer> t = adj.get(c[0]);
            t.add(c[1]);
            adj.put(c[0], t);

            t = adj.get(c[1]);
            t.add(c[0]);
            adj.put(c[1], t);
        }
        // visited matrix
        v = new boolean[n];
        Arrays.fill(v, false);
        int disconnectedNodes = 0;
        int extraCables = 0;
        for(int i=0;i<n;i++){
            if(!v[i]){
                disconnectedNodes++;
                q.clear();
                q.add(i);
                v[i] = true;
                extraCables += bfs(q);
            }
        }
        if(extraCables < (disconnectedNodes-1)) return -1;
        return disconnectedNodes-1;
    }

    int bfs(Queue<Integer> q){
        int ec = 0; //extra cables
        Set<String> visitedCables = new HashSet<>();
        while(!q.isEmpty()){
            int from = q.remove();
            for(Integer to : adj.get(from)){
                if(visitedCables.contains(from+"#"+to)) continue;
                if(v[to]){
                    ec++;
                }else{
                    v[to] = true;
                    q.add(to);
                }
                visitedCables.add(from+"#"+to);
                visitedCables.add(to+"#"+from);
            }
        }
        return ec;
    }
}
