package com.company.dbs_bfs_combined;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 * Telphonic round:
 * Given a 2d matrix with value 0 and -1. mat[i][j] == -1 is boundary pixel. Calculate the minimum distance of each node mat[i][j] from nearest boundary pixel.

 *
 * Distance is calculated as |x1-x2| + |y1-y2|
 * mat[i][j] =
 * 0 0 0
 * 0 -1 0
 * 0 0 0
 * Output:
 * mat[i][j]
 * 2 1 2
 * 1 0 1
 * 2 1 2
 *
 */

public class Google_ReturnDistanceOfNearest_0_ForEachCell {
    // multi point BFS
    int m, n;
    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j));
                    mat[i][j] = 0; // distance of this point from 0 wil be zero
                }else{
                    mat[i][j] = Integer.MAX_VALUE; // we assume for rest the distance is MAX
                }
            }
        }

        while(!q.isEmpty()){
            Pair one = q.remove();
            int i = one.x, j = one.y;
            // update max distance of all its 4 neighbours
            if(isValid(i-1, j)){
                updateDistance(q, mat, i-1, j, 1 + mat[i][j]);
            }
            if(isValid(i+1, j)){
                updateDistance(q, mat, i+1, j, 1 + mat[i][j]);
            }
            if(isValid(i, j-1)){
                updateDistance(q, mat, i, j-1, 1 + mat[i][j]);
            }
            if(isValid(i, j+1)){
                updateDistance(q, mat, i, j+1, 1 + mat[i][j]);
            }
        }
        return mat;
    }

    void updateDistance(Queue<Pair> q, int[][] mat, int i, int j, int D){
        if(D < mat[i][j]){
            // we found a better distance so update it ans add to queue so other positions relative to this can be updated
            mat[i][j] = D;
            q.add(new Pair(i,j));
        }
    }

    boolean isValid(int i ,int j){
        return (i >= 0 && j >=0 && i < m && j < n);
    }

    private class Pair{
        int x,y;
        Pair(int i, int j){
            this.x = i;
            this.y = j;
        }
    }
}
