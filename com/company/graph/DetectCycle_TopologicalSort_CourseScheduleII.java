package com.company.graph;

import java.util.*;

/**
 *
 * 210. Course Schedule II
 * Medium
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 *     For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 *
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 *
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 *
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 */

public class DetectCycle_TopologicalSort_CourseScheduleII {
    Set<Integer> notVisited;
    Set<Integer> currentlyBeingExplored;
    Set<Integer> fullyExplored;
    HashMap<Integer, ArrayList<Integer>> adj;
    ArrayList<Integer> res;
    boolean cycle = false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //topological sort + detect cycle
        int l = numCourses;
        notVisited = new HashSet<>();
        currentlyBeingExplored = new HashSet<>();
        fullyExplored = new HashSet<>();
        res = new ArrayList<Integer>();
        adj = new HashMap<>();

        // setup unexplorered set and Adjacency matrix
        for(int i = 0;i<l;i++) {
            notVisited.add(i);
            adj.put(i, new ArrayList<Integer>());
        }
        // fill up the adjacency matrix
        for(int[] p : prerequisites){
            adj.get(p[0]).add(p[1]);
        }
        // till all nodes are visited try and visit them
        for(int i =0;i<l;i++){
            if(notVisited.contains(i)) {
                notVisited.remove(i);
                topologicalSort(i);
            }
        }
        if(cycle == true){
            return new int[0];
        }else{
            return res.stream().mapToInt(i -> i).toArray();
        }
    }

    /**
     * Here main logic is that before exploring a node we remove it from notVisitedSet and put it into currentlyBeingExplored set
     * Then we do dfs on that node and fully explores it, during that time we again come across that node that means there is aycle
     * After fully exploring the children we remove the parent from currentlyBeingExplored set and move it to fullyExploredSet
     * @param node
     */
    public void topologicalSort(int node){
        if(cycle == true) return;
        if(fullyExplored.contains(node)) return; // this node is fully explored
        if(currentlyBeingExplored.contains(node)) {
            cycle = true;
            return;
        }
        currentlyBeingExplored.add(node);
        // go to all children first and after fully exploring all children push them to ans and remove them from currentlyBeingExplored
        for(int childNode : adj.get(node)){
            notVisited.remove(childNode);
            topologicalSort(childNode);
        }
        // now add parent to result
        res.add(node);
        // reomve from currentlyBeingExplored set
        currentlyBeingExplored.remove(node);
        // add to fullyExplored
        fullyExplored.add(node);

    }
}
