package com.company.priorityqueue_heap;

import java.util.PriorityQueue;

/**
 * 973. K Closest Points to Origin
 * Medium
 *
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 *
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 */

public class K_closest_points_to_origin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->{
            double d1 = Math.sqrt((a[0]*a[0])+(a[1]*a[1]));
            double d2 = Math.sqrt((b[0]*b[0])+(b[1]*b[1]));
            if(d2 > d1){
                return 1;
            }
            return -1;
        });
        int l = points.length;

        for(int[] n : points){
            // we need to keep K el in queue in desc order
            if(q.size() < k){
                q.add(n);
            }else{
                // if new el is smaller then pop
                if(distance(n) < distance(q.peek())){
                    q.remove();
                    q.add(n);
                }
            }
        }
        int[][] ans = new int[k][2];
        int i =0;
        while(!q.isEmpty()) {
            ans[i++] = q.remove();
        }
        return ans;
    }

    double distance(int[] a){
        return Math.sqrt((a[0]*a[0])+(a[1]*a[1]));
    }
}
