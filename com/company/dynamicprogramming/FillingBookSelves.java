package com.company.dynamicprogramming;

/**
 *
 * 1105. Filling Bookcase Shelves
 * Medium
 *
 * You are given an array books where books[i] = [thicknessi, heighti] indicates the thickness and height of the ith book. You are also given an integer shelfWidth.
 *
 * We want to place these books in order onto bookcase shelves that have a total width shelfWidth.
 *
 * We choose some of the books to place on this shelf such that the sum of their thickness is less than or equal to shelfWidth, then build another level of the shelf of the bookcase so that the total height of the bookcase has increased by the maximum height of the books we just put down. We repeat this process until there are no more books to place.
 *
 * Note that at each step of the above process, the order of the books we place is the same order as the given sequence of books.
 *
 *     For example, if we have an ordered list of 5 books, we might place the first and second book onto the first shelf, the third book on the second shelf, and the fourth and fifth book on the last shelf.
 *
 * Return the minimum possible height that the total bookshelf can be after placing shelves in this manner.
 *
 *
 *
 * Example 1:
 *
 * Input: books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelf_width = 4
 * Output: 6
 * Explanation:
 * The sum of the heights of the 3 shelves is 1 + 3 + 2 = 6.
 * Notice that book number 2 does not have to be on the first shelf.
 *
 * Example 2:
 *
 * Input: books = [[1,3],[2,4],[3,2]], shelfWidth = 6
 * Output: 4
 */

public class FillingBookSelves {
    // we have option to add book in existing shelf IF_POSSIBLE in this case the height will be max(max height of on-going level, max of the book to be added)
    // or we can add a entire new shelf and then height will increase by b[i][1]
    public int minHeightShelves(int[][] b, int w) {
        int l = b.length;
        // dp[i] is the min height of bookself till i
        int[] dp = new int[l+1];
        dp[0] = 0; // base condition
        for(int i=1;i<=l;i++){
            // we assume the worse case that we will add another bookself
            int height = b[i-1][1];
            int width = b[i-1][0];
            dp[i] = dp[i-1] + height;

            // here are counting from 1 beacuse dp[0] is solution when there are 0 books
            // so j = 1 means book 1 but which is equal to b[j-1] (in books array counting is from 0)
            for(int j = i-1;j>0;j--){
                width += b[j-1][0];
                if(width <= w){
                    height = Math.max(height, b[j-1][1]);
                    dp[i] = Math.min(dp[i], height+dp[j-1]);
                }else{
                    break;
                }
            }
        }
        return dp[l];
    }
}
