package com.company.priorityqueue_heap;

import java.util.*;

/**
 * 2158. Amount of New Area Painted Each Day
 * https://walkccc.me/LeetCode/problems/2158/
 * There is a long and thin painting that can be represented by a number line.
 * You are given a 0-indexed 2D integer array paint of length n, where
 * paint[i] = [start₁, end₁]. This means that on the ith day you need to
 * paint the area between start `i` and end `i`.
 * Painting the same area multiple times will create an uneven painting so
 * you only want to paint each area of the painting at most once.
 * Return an integer array worklog of length n, where worklog[i] is the
 * amount of new area that you painted on the ith day.
 */

public class Google_AmountOfAreaPaintedEachDay {
    /**
     *
     * In this we are maintaining a array ans = [0,0,0] of size N number of days
     * We sort the input by starting X index and keep track of the index (aka which day we had to start with this index) of this staring day and use it to update paint used on ech day
     * We don't fill the ans array from dat 1 to n
     *
     */

    /**
     * Time ->  Nlog(N)  (Nlog(N) for sorting and again Nlog(N) for each treeset operation so 2Nlog(N))
     * Space ->  N+D        (N for event + number of days = len(a) for set)
     */
    public int[] paint(int[][] a){
        // find max/min coordinates of painting
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        List<Event> e = new ArrayList<>();
        int[] ans = new int[a.length];
        int i =0;
        for(int[] x : a){
            max = Math.max(max, x[1]); //max from ending coordinate
            min = Math.min(min, x[0]); // min from starting coordinate
            e.add(new Event(x[0], i, 0)); // day with index `i` is starting
            e.add(new Event(x[1], i, 1)); // day with index `i` is ending
            i++;
        }
        Collections.sort(e, (p,q)->{return p.position-q.position;}); //ASC order Nlog(N)
        // this will tell that the paint that we filled at a particular position/coordinate of the painting
        // it belonged to which `index` or day and we do ans[index/day]++;
        TreeSet<Integer> q = new TreeSet<>(); // ASC order

        i = 0;
        // position/ coordinate loop
        for(int x = min; x<max ; x++){
            // process all event for the current coordinate
            while(i < e.size() && e.get(i).position == x){
                Event event = e.get(i);
                if(event.type == 0){
                    // day starting
                    q.add(event.dayIndex);
                }else{
                    // day ending
                    // tree set deletes in log(N)
                    q.remove(event.dayIndex);
                }
                i++;
            }
            // after processing all the event for the current coordinate/position
            if(q.size()>0){
                // there is a event ongoing, so we add paint for this coordinate for smallest index on set because that day started first
                ans[q.first()]++;
            }
        }
        return ans;
    }

    private class Event{
        int position, dayIndex, type;
        Event(int p, int i, int t){
            this.position = p;
            this.dayIndex = i;
            this.type = t; // 0 is starting, 1 is ending
        }
    }
}
