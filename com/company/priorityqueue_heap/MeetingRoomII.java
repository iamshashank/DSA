package com.company.priorityqueue_heap;

import java.util.*;

/**
 * Given intervals of meeting find out how many min number of conference rooms are required
 * [s1, e1], [s2,e2] start and end time are given
 * This is exact same as NonOverLappingIntervals with small variation
 * in this we have to find max-level of overlap or how many overlaps are happening at a time
 * [1,4] [2, 4], [3, 5] [4, 6] in this 3 intervals ([1,4] [2, 4], [3, 5]) are overlapping simultaneously, so we need a min of 3 meeting room
 */

/**
 *
 *
 *
 */
public class MeetingRoomII {
    public int process(int[][] a){
        int start[] = new int[a.length];
        int end[] = new int[a.length];
        for(int i=0;i<a.length;i++){
            start[i] = a[i][0];
            end[i] = a[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int meetingRoomAlocated = 0;

        for(int i =0, j = 0;i<a.length;i++){
            // isme `j` tells us ki kaun si meeting khatam hone wali hai (sorted ending time)
            // so agar, jo current meeting hai start[i] agar vo khatam hone wali se pahele hi start ho rahi to we need a new room
            if(start[i] < end[j]){
                meetingRoomAlocated++;
            }else{
                j++;
            }
        }
        return meetingRoomAlocated;
    }


    // USING PRIORITY QUEUE
    public class Interval {
        int start; int end;
        Interval(int s, int e) { start = s; end = e; }
    }

    public int minMeetingRooms(Interval[] intervals) {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // Min heap will store endtime in ascending
        PriorityQueue<Integer> allocator = new PriorityQueue<>((a, b)->{return a-b;});

        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b)->{return a.start - b.start;});

        // Add the first meeting
        allocator.add(intervals[0].end);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i].start >= allocator.peek()) {
                allocator.remove();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i].end);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }


    // SWEEP LINE or OVERLAP METHOD

    public int sweepLine(int[][] a){
        List<TimeStamp> t = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            t.add(new TimeStamp(a[i][0], 0));
            t.add(new TimeStamp(a[i][1], 1));
        }
        Collections.sort(t, (x,y)->{
            //if both time equal we will free up the room first so pahele end time ayega
            if(x.time == y.time){
                return y.type - x.type;
            }
            return x.time - y.time;
        });
        int overlap = 0;
        int maxOverlap = 0;
        for(TimeStamp stamp: t){
            if(stamp.type == 0){
                // meeting start ho rahi to increment
                overlap++;
            }else{
                // meeting khatam ho rahi so free the meting room
                overlap--;
            }
            maxOverlap = Math.max(overlap, maxOverlap);
        }
        return maxOverlap;
    }

    private class TimeStamp{
        int time;
        int type; // 0 is start time 1 is end time
        TimeStamp(int time, int type){
            this.time = time;
            this.type = type;
        }
    }
}
