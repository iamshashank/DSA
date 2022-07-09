package com.company.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * https://www.youtube.com/watch?v=-7zxQzs3D2A
 * 773. Sliding Puzzle
 * Hard
 *
 * On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0. A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 *
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 *
 * Given the puzzle board board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 *
 * Example 2:
 *
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 *
 * Example 3:
 *
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 */


public class Google_HARD_SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        // BFS
        Queue<String> q = new LinkedList<>();
        Set<String> v = new HashSet<>();

        // instead of 2d mapping we assign 0 to 5 linear index to each cell
        // valid moves `i` tells the position of 0 in the string
        // and moves[i] will be a array which tells to which indexes we can swap
        int[][] moves = new int[][]{ {1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

        q.add(string(board));
        int move = 0;

        while(!q.isEmpty()){

            int  l = q.size();
            for(int j=0;j<l;j++){
                String s = q.remove();
                if(s.equals(target)) return move;
                if(v.contains(s)) continue;
                v.add(s);
                int idx = s.indexOf('0');
                StringBuilder sb = new StringBuilder(s);
                for(int i=0;i<moves[idx].length;i++){
                    String x = swap(idx, moves[idx][i], sb);
                    if(!v.contains(x)){
                        q.add(x);
                    }
                }
            }

            move++;
        }
        return -1;
    }

    String string(int[][] a){
        return ""+a[0][0]+a[0][1]+a[0][2]+a[1][0]+a[1][1]+a[1][2];
    }

    String swap(int i, int j, StringBuilder sb){
        char one = sb.charAt(i);
        char two = sb.charAt(j);
        String ans = "";
        sb.setCharAt(i, two);
        sb.setCharAt(j, one);
        ans = sb.toString();
        sb.setCharAt(j, two);
        sb.setCharAt(i, one);
        return ans;
    }
}
