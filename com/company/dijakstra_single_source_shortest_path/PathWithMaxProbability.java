package com.company.dijakstra_single_source_shortest_path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1514. Path with Maximum Probability
 * Medium
 *
 * You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].
 *
 * Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.
 *
 * If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
 * Output: 0.25000
 * Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
 */

public class PathWithMaxProbability {

    // dijakstra single source shortest path O(E log(v))
    public double maxProbability(int n, int[][] edges, double[] sp, int start, int end) {
        // adj map
        HashMap<Integer, List<Pair>> adj = new HashMap<>();
        for(int i=0;i<n;i++) adj.put(i, new ArrayList<>());

        for(int i =0;i<edges.length;i++){
            int[] e = edges[i];

            List<Pair> t = adj.get(e[0]);
            t.add(new Pair(e[1], sp[i]));
            adj.put(e[0], t);

            t = adj.get(e[1]);
            t.add(new Pair(e[0], sp[i]));
            adj.put(e[1], t);
        }


        // map + heap
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b)->{
            if(b.pro >= a.pro) return 1;
            return -1;
        });
        HashMap<Integer, Pair> map = new HashMap<>();


        for(int i =0;i<n;i++){
            Pair t = new Pair(i, 0);
            if(i == start){
                t.pro = 1; // start can reach start with probability of 1
            }
            q.add(t);
            map.put(i, t);
        }

        //parent map
        HashMap<Integer, Integer> p = new HashMap<>();
        p.put(0, -1);
        // min distance map
        HashMap<Integer, Double> maxPro = new HashMap<>();

        while(!q.isEmpty()){
            Pair from = q.remove();
            map.remove(from.to);

            // we found final ans for from.to
            maxPro.put(from.to, from.pro);
            for(Pair to : adj.get(from.to)){
                if(!map.containsKey(to.to)) continue; // we already found solution for this node
                double mp = from.pro * to.pro;

                // check in queue and update the probabilities
                Pair t = map.get(to.to);
                if(mp > t.pro){
                    p.put(to.to, from.to);
                    q.remove(t);
                    t.pro = mp;
                    q.add(t);
                }
            }

        }

        return maxPro.get(end);
    }

    class Pair{
        public int to;
        public double pro;
        Pair(){}
        Pair(int to, double pro){
            this.to = to;
            this.pro  = pro;
        }
        public String toString(){
            return this.to + ":" + this.pro + ", ";
        }
    }
}
