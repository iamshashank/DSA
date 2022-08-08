package com.company.game_theory;

import java.util.Arrays;

/**
 * 1025. Divisor Game
 * Easy
 *
 * Alice and Bob take turns playing a game, with Alice starting first.
 *
 * Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
 *
 *     Choosing any x with 0 < x < n and n % x == 0.
 *     Replacing the number n on the chalkboard with n - x.
 *
 * Also, if a player cannot make a move, they lose the game.
 *
 * Return true if and only if Alice wins the game, assuming both players play optimally.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: true
 * Explanation: Alice chooses 1, and Bob has no more moves.
 *
 * Example 2:
 *
 * Input: n = 3
 * Output: false
 * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 1000
 */

public class DivisorGame {
    int[]dp;
    public boolean divisorGame(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return game(n, 0) == 1;
    }

    // here player tell ki kiski turn hai to make a move
    int game(int n, int player){

        if(n <= 1){
            // look at the example case if n is less than 2 then the player looses and if n is 2 then that player wins
            // ab to jiski turn hai vo haaarega
            if(player == 0){
                return 0;
            }else{
                return 1;
            }
        }

        if(dp[n] != -1) return dp[n];

        int nextPlayer = player == 1 ? 0 : 1;
        for(int i = 1;i<n;i++){
            if(n%i == 0 && game(n-i, nextPlayer) == 1){
                return dp[n] = 1;
            }
        }
        return dp[n] = 0;
    }
}
