package com.company.dijakstra_single_source_shortest_path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1976. Number of Ways to Arrive at Destination
 * Medium
 *
 * You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.
 *
 * You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.
 *
 * Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
 * Output: 4
 * Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
 * The four ways to get there in 7 minutes are:
 * - 0 ➝ 6
 * - 0 ➝ 4 ➝ 6
 * - 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
 * - 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
 *
 * Example 2:
 *
 * Input: n = 2, roads = [[1,0,10]]
 * Output: 1
 * Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 200
 *     n - 1 <= roads.length <= n * (n - 1) / 2
 *     roads[i].length == 3
 *     0 <= ui, vi <= n - 1
 *     1 <= timei <= 109
 *     ui != vi
 *     There is at most one road connecting any two intersections.
 *     You can reach any intersection from any other intersection.
 */

public class NumberOfWaysToArriveAtDestination {
    // Dijakstra single source shortest path
    public int countPaths(int n, int[][] roads) {
        // create adj matrix
        HashMap<Integer, List<Pair>> adj = new HashMap<>();
        for(int i=0;i<n;i++) adj.put(i, new ArrayList<Pair>());
        for(int[] r : roads){
            List<Pair> t = adj.get(r[0]);
            t.add(new Pair(r[1], r[2]));
            adj.put(r[0], t);

            t = adj.get(r[1]);
            t.add(new Pair(r[0], r[2]));
            adj.put(r[1], t);
        }
        // Create Heap+Map to track maintain remaining nodes
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b)->{
            if(a.two > b.two) return 1;
            return -1;
        });
        HashMap<Integer, Pair> map = new HashMap<>();

        // Map to store min time from source that are finalised
        HashMap<Integer, Long> minDistMap = new HashMap<>();
        // map to store parent of each node in the shortest path
        HashMap<Integer, Integer> parent = new HashMap<>();

        // stores ways to reach a particular node
        // ways[2] = 3 means we have 3 shortest ways to reach node 2
        int[] ways = new int[n];
        ways[0] = 1;
        parent.put(0, -1);

        //intitally every node is at distnace of MAX from source
        // parent of node 0 is -1 and it distance from source/0 is also 0
        for(int i =0;i<n;i++){
            Pair t = new Pair(i, Long.MAX_VALUE);
            if(i == 0) t.two = 0;
            q.add(t);
            map.put(i, t);
        }

        while(!q.isEmpty()){
            Pair from = q.remove();
            map.remove(from.one);
            // add to minDistMap, we have finalised the min time for this node
            minDistMap.put(from.one, from.two);

            for(Pair to : adj.get(from.one)){
                if(!map.containsKey(to.one)) continue;
                long time = from.two + to.two;
                long timeInQueue = map.get(to.one).two;
                if(time < timeInQueue){
                    // we found a better time
                    // update parent
                    parent.put(to.one, from.one);
                    // update queue
                    Pair t = map.get(to.one);
                    q.remove(t);
                    t.two = time;
                    q.add(t);
                    //update ways
                    ways[to.one] = ways[from.one];
                }else if(time == timeInQueue){
                    // we found a new path to reach :to in shortest time
                    ways[to.one] = (int)(((long)ways[to.one] + (long)ways[from.one])%1000000007);
                }
            }

            // System.out.println(Arrays.toString(ways));
        }
        return ways[n-1];


    }

    private class Pair{
        // two = time
        public int one;
        public long two;
        Pair(int a, long b){
            this.one = a;
            this.two = b;
        }
    }
}
