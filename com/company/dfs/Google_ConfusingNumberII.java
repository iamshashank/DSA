package com.company.dfs;

import java.util.HashMap;

/**
 *
 * 1088. Confusing Number II
 * Level
 *
 * Hard
 * Description
 *
 * Given a number N, return true if and only if it is a confusing number, which satisfies the following condition:
 *
 * We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are rotated 180 degrees, they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid.
 *
 * A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid. (Note that the rotated number can be greater than the original number.)
 *
 * Given a positive integer N, return the number of confusing numbers between 1 and N inclusive.
 *
 * Example 1:
 *
 * Input: 20
 *
 * Output: 6
 *
 * Explanation:
 *
 * The confusing numbers are [6,9,10,16,18,19].
 *
 * 6 converts to 9.
 *
 * 9 converts to 6.
 *
 * 10 converts to 01 which is just 1.
 *
 * 16 converts to 91.
 *
 * 18 converts to 81.
 *
 * 19 converts to 61.
 *
 * Example 2:
 *
 * Input: 100
 *
 * Output: 19
 *
 * Explanation:
 *
 * The confusing numbers are [6,9,10,16,18,19,60,61,66,68,80,81,86,89,90,91,98,99,100].
 *
 * Note:
 *
 *     1 <= N <= 10^9
 *
 */

public class Google_ConfusingNumberII {
    HashMap<Character, Integer> map = new HashMap<>();
    int[] g = new int[]{0,1,6,8,9};
    public int process(int N){
        if(N>10000000) return 0;
        int ans = 0;
        map.put('0', 0);
        map.put('1', 1);
        map.put('6', 9);
        map.put('8', 8);
        map.put('9', 6);
        int[] availableLetters = new int[]{1,6,8,9};
        // we are ignoring 0 because you cannot start a number with 0
        for(int i = 0;i<availableLetters.length;i++){
            ans += dfs(N, availableLetters[i]);
        }
        return ans;
    }

    private int dfs(int N, int currN) {
        int ans = 0;
        if(currN > N){
            return 0;
        }
        if(isConfusing(currN)) ans++;
        if(currN == N) return ans;
        // small optimization to reduce dfs calls
        // in the loop we are multiplying by 10 so if after multiplying the number
        if(currN*10 > N) return ans;
        for(int i =0; i<g.length; i++){
            ans += dfs(N, (currN*10)+g[i]);
        }
        return ans;
    }

    public boolean isConfusing(int n){
        StringBuilder s = new StringBuilder(String.valueOf(n));
        int ans = 0;
        for(int i = 0;i < s.length();i++){
            if(map.containsKey(s.charAt(i))){
                ans += map.get(s.charAt(i))*Math.pow(10, i);
            }else{
                return false;
            }
        }
//        System.out.println(ans);
        return n != ans;
    }
}
