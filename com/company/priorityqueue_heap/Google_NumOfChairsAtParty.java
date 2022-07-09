package com.company.priorityqueue_heap;

import java.util.*;

/**
 * Given start time and end time of each guest
 * how many chairs are needed at max
 * Input: S = [1, 2, 6, 5, 3], E = [5, 5, 7, 6, 8]
 * Output: 3
 * Explanation:
 * There are five guests attending the party.
 * The 1st guest will arrive at time 1. We need one chair at time 1.
 * The 2nd guest will arrive at time 2. There are now two guests at the party, so we need two chairs at time 2.
 * The 5th guest will arrive at time 3. There are now three guests at the party, so we need three chairs at time 3.
 * The 4th guest will arrive at time 5 and, at the same moment, the 1st and 2nd guests will leave the party.
 * There are now two (the 4th and 5th) guests at the party, so we need two chairs at time 5.
 * The 3rd guest will arrive at time 6, and the 4th guest will leave the party at the same time.
 * There are now two (the 3rd and 5th) guests at the party, so we need two chairs at time 6.
 * So we need at least 3 chairs.
 *
 *
 *
 * ORR
 * Find the point where maximum intervals overlap
 *
 * Consider a big party where a log register for guest’s entry and exit times is maintained. Find the time at which there are maximum guests in the party. Note that entries in register are not in any order.
 * Example :
 *
 * Input: arrl[] = {1, 2, 9, 5, 5}
 *        exit[] = {4, 5, 12, 9, 12}
 * First guest in array arrives at 1 and leaves at 4,
 * second guest arrives at 2 and leaves at 5, and so on.
 *
 * Output: 5
 * There are maximum 3 guests at time 5.
 *
 *
 */
public class Google_NumOfChairsAtParty {
    public int chairsNeeded(int[] s, int[] e){
        Arrays.sort(s);
        Arrays.sort(e);
        int j = 0;
        int ans = 0;
        for(int i=0;i<s.length;i++){
            if(s[i] < e[j]){
                ans++; //need more chair
            }else{
                j++; // remove the guest from list
            }
        }
        return ans;
    }

    // 2nd Logic with SweepLine ovelap
    public int sweepMethod(int[] s, int[] e){
        List<Interval> ev = new ArrayList<>();
        for(int i=0;i<s.length;i++){
            ev.add(new Interval(s[i], 0));
            ev.add(new Interval(e[i], 1));
        }
        Collections.sort(ev, (a,b)->{
            if(a.time == b.time){
                return b.type - a.type; // end time will come first
            }
            return a.time-b.time;
        });
        System.out.println(ev);
        int chairNeeded = 0;
        int maxChair = 0;
        for(Interval interval : ev){
            if(interval.type == 0){
                chairNeeded++;
            }else{
                chairNeeded--;
            }
            maxChair = Math.max(maxChair, chairNeeded);
        }
        return maxChair;
    }

    private class Interval{
        private int time, type; // 0 is start time, 1 is end time
        Interval(int t, int type){
            this.time = t;
            this.type = type;
        }

        public String toString(){
            return time + " : " +type;
        }
    }
}
