package com.company.minimum_spanning_tree;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * 1584. Min Cost to Connect All Points
 * Medium
 *
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 *
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 *
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 * Explanation:
 *
 * We can connect the points as shown above to get the minimum cost of 20.
 * Notice that there is a unique path between every pair of points.
 *
 * Example 2:
 *
 * Input: points = [[3,12],[-2,5],[-4,1]]
 * Output: 18
 *
 *
 *
 * Constraints:
 *
 *     1 <= points.length <= 1000
 *     -106 <= xi, yi <= 106
 *     All pairs (xi, yi) are distinct.
 *
 */

public class MinimumSpanningTree {
    int[] parent, rank;
    public int minCostConnectPoints(int[][] p) {
        int l = p.length;
        PriorityQueue<Edge> q = new PriorityQueue<>((a, b)->{return a.cost - b.cost;});
        boolean[] v = new boolean[l]; // we have `l` points
        Arrays.fill(v, false);
        int count = l-1;
        rank = new int[l];
        parent = new int[l];
        for(int i=0;i<l;i++) parent[i] = i;

        // find all possible edeges from each node to very other node
        for(int i=0;i<l;i++){
            for(int j=i+1;j<l;j++){
                if(i!=j){
                    int dx = p[i][0] - p[j][0];
                    int dy = p[i][1] - p[j][1];
                    q.add(new Edge(i, j , Math.abs(dx)+ Math.abs(dy)));
                }
            }
        }
//        System.out.println(q);
        int cost = 0; // this keeps track of how many points we have connected
        while(!q.isEmpty() && count > 0){
            Edge e = q.remove();

            if(v[e.a] && v[e.b] && getParent(e.a) == getParent(e.b)){
                // both point visited so ignore this edge
            }else{
                // either both not visited or any 1 not visited
                count--;
                union(e.a, e.b);
                v[e.a] = true;
                v[e.b] = true;
                cost += e.cost;
            }
        }
        return cost;
    }

    int getParent(int node){
        if(node == parent[node]) return node;
        return getParent(parent[node]);
    }

    void union(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(rank[b]>rank[a]){
            parent[a] = b;
            rank[b]++;
        }else{
            parent[b] = a;
            rank[a]++;
        }
    }

    class Edge{
        public int a, b, cost;
        Edge(int a, int b , int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        public String toString() {
            return "["+a+" "+b+" "+cost+"]";
        }
    }
}
