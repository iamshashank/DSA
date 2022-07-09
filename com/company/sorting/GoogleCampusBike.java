package com.company.sorting;

import java.util.*;


/**
 *
 *
 *
 *
 *
 * On a campus represented as a 2D grid, there are Nworkers and Mbikes, with N <= M. Each worker and bike is a 2D coordinate on this grid.
 *
 * Our goal is to assign a bike to each worker. Among the available bikes and workers, we choose the (worker, bike) pair with the shortest Manhattan distance between each other, and assign the bike to that worker.
 * (If there are multiple (worker, bike) pairs with the same shortest Manhattan distance,
 * we choose the pair with the smallest worker index; if there are multiple ways to do that, we choose the pair with the smallest bike index). We repeat this process until there are no available workers.
 *
 * The Manhattan distance between two points p1and p2is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|. Return a vector ans of length N, where ans[i] is the index (0-indexed) of the bike that the i-th worker is assigned to.
 *
 *Input:
 * workers = [[0,0],[2,1]],
 * bikes = [[1,2],[3,3]]
 * Output:
 * [1,0]
 *
 * Input:
 * workers = [[0,0],[1,1],[2,0]],
 * bikes = [[1,0],[2,2],[2,1]]
 * Output:
 * [0,2,1]
 */
public class GoogleCampusBike {

    public int[] process(int[][] w, int[][] b){
        List<int[]>[] list = new List[2001];

        for(int i =0; i< w.length;  i++){
            for(int k =0;k<b.length;k++){
                int dis = Math.abs(w[i][0] - b[k][0]) + Math.abs(w[i][1] - b[k][1]);
                if(list[dis] == null){
                    list[dis] = new ArrayList<>();
                }
                // this will take care of the condition which says that if distance is same for 2 or more (worker, bike) pair
                // the if w1 < w2  the w1 will ge the bike
                // its automatically manges here because we are first adding workers from i = 0 to n so w[0] will always be before w[2]
                list[dis].add(new int[]{i, k});
            }
        }
        int[] res = new int[w.length];
        Arrays.fill(res, -1);
        Set<Integer> assignedBike = new HashSet<>();
        for(int i =0; i< 2001 && assignedBike.size() < w.length ;i++){
            if(list[i] != null) {
                for (int[] workerBikeCombo : list[i]) {
                    // `i` is the worker index
                    // `j` is the bike to be alloted
                    if (res[workerBikeCombo[0]] == -1 && !assignedBike.contains(workerBikeCombo[1])) {
                        res[workerBikeCombo[0]] = workerBikeCombo[1];
                        assignedBike.add(workerBikeCombo[1]);
                    }
                }
            }
        }
        return res;
    }
}
