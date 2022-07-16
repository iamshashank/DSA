package com.company.priorityqueue_heap;

import java.util.*;

/**
 * 218. The Skyline Problem
 * Hard
 *
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.
 *
 * The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:
 *
 *     lefti is the x coordinate of the left edge of the ith building.
 *     righti is the x coordinate of the right edge of the ith building.
 *     heighti is the height of the ith building.
 *
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 *
 * The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost building ends. Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.
 *
 * Note: There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...,[2 3],[4 5],[12 7],...]
 *
 *
 *
 * Example 1:
 *
 * Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * Explanation:
 * Figure A shows the buildings of the input.
 * Figure B shows the skyline formed by those buildings. The red points in figure B represent the key points in the output list.
 *
 * Example 2:
 *
 * Input: buildings = [[0,2,3],[2,5,3]]
 * Output: [[0,3],[5,0]]
 *
 *
 */

public class Hard_CitySkyline {
    public List<List<Integer>> getSkyline(int[][] b) {
        int l = b.length;
        List<List<Integer>> ans = new ArrayList<>();
        // convert the input into building coordinates which represent top left and top right
        // for each building we need to point 1. for left and 1. for right
        // the last value 0, 1 in each point indicate that 0 == start of building 1 indicate end of a building
        int[][] p = new int[l*2][3];
        for(int i=0;i<l;i++){
            p[i*2] = new int[]{b[i][0], b[i][2], 0};
            p[(i*2)+1] = new int[]{b[i][1], b[i][2], 1};
        }

        //if two starts are compared then higher height building should be picked first
        //if two ends are compared then lower height building should be picked first
        //if one start and end is compared then start should appear before end
        Arrays.sort(p, (x, y)->{
            //whichever building comes first on X-axis
            if(x[0] != y[0]){
                return x[0] - y[0];
            }
            if(x[2] == 0 && y[2] == 0){
                // pick taller building
                return y[1] - x[1];
            }
            if(x[2] == 1 && y[2] == 1){
                // pick smaller building
                return x[1] - y[1];
            }

            return x[2] - y[2];
        });

        // for(int i =0;i<p.length;i++) System.out.println(Arrays.toString(p[i]));

        PriorityQueue<Integer> q = new PriorityQueue<>((x,y)->{return y-x;});
        // in priority queue we will store the max height of the building which is ongoing
        // it is sorted in descending
        q.add(0); // by default max height is 0
        int maxInQueue = 0;
        for(int i=0;i<2*l;i++){

            if(p[i][2] == 0){
                // this point is start of a building
                // add the y coordinate in queue and if max value in queue changes then add this point in ans
                q.add(p[i][1]);
            }else{
                // end of building
                // remove the height from queue and check if max in queue changes
                q.remove(p[i][1]);
            }


            int currMax = q.peek();
            if(currMax != maxInQueue){
                ArrayList<Integer> t = new ArrayList<>();
                t.add(p[i][0]); // x-value
                t.add(currMax);     // y-value
                ans.add(t);
                maxInQueue = currMax;
            }

        }
        return ans;
    }
}
