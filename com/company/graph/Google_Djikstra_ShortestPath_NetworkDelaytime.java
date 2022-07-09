package com.company.graph;

import java.util.*;

/**
 *
 * 743. Network Delay Time
 * Medium
 *
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 *
 * Example 2:
 *
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 *
 * Example 3:
 *
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 *
 */

public class Google_Djikstra_ShortestPath_NetworkDelaytime {
    int max = 0;
    HashMap<Integer, List<int[]>> adj;
    int[] dist;
    public int networkDelayTime(int[][] times, int n, int k) {
        int l = times.length;
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // minimum n-1 edges required
        if(l < n-1) return -1;

        adj = new HashMap<>();
        for(int i =1;i<=n;i++)
            adj.put(i, new ArrayList<>());

        for(int i = 0;i< l;i++){
            int[] a = times[i];
            adj.get(a[0]).add(new int[]{a[1], a[2]});
        }
        dist[k] = 0; // because we start from here
        bfs(k);
        // since each dist[i] now stores the min distance to reach `i` the max value in this dist[] is time taken to reach the last node
        for(int i =1;i<=n;i++) max = Math.max(max, dist[i]);

        // if max = Integer.MAX_VALUE that means its disconnected graph
        return max == Integer.MAX_VALUE ? -1 : max;
    }


    /**
     *
     * In this directed graph we use a modified bfs in which we dont keep a visited node
     * Since we are given weight of each edge we rely on the condition (minimise cost to reach each node) to prevent endless cycle
     * @param node
     */
    void bfs(int node){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{return a[1] - b[1];}); // sorted by distance
        pq.add(new int[]{node, 0});// we start with k

        while(!pq.isEmpty()){
            int[] fromNode = pq.remove();

            if(fromNode[1] > dist[fromNode[0]]) continue;

            for(int[] toNode : adj.get(fromNode[0])){ // we look at all connecting nodes of the curr
                int newDist = fromNode[1] + toNode[1]; // new dist to reach toNode[0] from fromNode[0]
                if(newDist < dist[toNode[0]]){
                    //we found a smaller distance
                    // we dont have a visited array in this bfs so this is check will eventually empty the queue
                    dist[toNode[0]] = newDist;
                    pq.add(new int[]{toNode[0], newDist});
                }
            }
        }
    }
}
