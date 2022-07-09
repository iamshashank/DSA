package com.company.priorityqueue_heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Problem Statement:
 * There is a Hospital which contain N rooms from 1 to N -1. There is a Queue of Patients outside the Hospital.
 * Each patient will be served in a single room and each patient has a time duration that it will take for the treatment.
 * The rooms are allocated to patients by the lowest index (if the room is free).
 * Initially room1 will be given to the patient, then if the 2nd patient comes and the 1st room is still busy,
 * then the room2 will be given to the 2nd patient. now suppose the 1st patient treatment is completed, and the room1 is free now,
 * and a new patient comes, then room1 will be given to the new patient.
 * Each Patient has a start time also (Consider this as appointment time for him, it needs not to be a time format, use Integer for this).
 *
 * The patients standing in the queue are in non-decreasing order of their start time.
 * means if the first patient start time = 1, then the second patient start time will be >= 1.
 * Now the rooms will be allocated to each patient's one by one.
 * we have to calculate that by the end when all the patients are treatment done,
 * Which is the room in which the maximum no of patients have been entered?
 *
 * Example:
 * if N = 2 rooms, and the patients are = 3, which are below
 *
 *  patient-1 = {start: 1, duration: 8}
 *  patient-2 = {start: 1, duration: 2}
 *  patient-3 = {start: 6, duration: 4}
 *
 * Now first patient will be assigned to room-1, second patient comes at the same time he will be allocated to room-2, now after time 2,
 * room-2 will become free, but patient 3 will come at time 6 and at that time he will be allocated to room-2 as well.
 * so finally room-2 is the room in which the max number of patients have entered.
 */


/**
 * TC : O(Patients * log (room ) ) SC: O(min(patients, room)) // for the set/queue
 */
public class Google_PatientQueue {
    // we are given start time  + duration (we are not given end time)
    public int process(int n, int[][] patients){
        int max = 0, maxIndex = 0;
        int[] freq = new int[n+1];
        // initially all rooms free
        TreeSet<Integer> freeRoomIndex = new TreeSet<>();
        for(int i =1;i<=n;i++) freeRoomIndex.add(i);

        PriorityQueue<Room> filledRoom = new PriorityQueue<>((a, b)->{
            if(a.end != b.end) return a.end - b.end; // pahele room clear kar do
            return a.start - b.start;
        });

        // patient already sorted by their start time
        for(int[] p : patients){
//            System.out.println(filledRoom);
            // free up the rooms
            while(!filledRoom.isEmpty() && filledRoom.peek().end <= p[0]){
                // free this room
                Room t = filledRoom.remove();
                freeRoomIndex.add(t.room);
            }
            // assign the room
            int room = freeRoomIndex.pollFirst();
            freq[room]++;
            if(freq[room]>max){
                max = freq[room];
                maxIndex = room;
            }
            filledRoom.add(new Room(p[0], p[0]+p[1], room)); // start time + duration = endtime
        }
        System.out.println(Arrays.toString(freq));
        return maxIndex;
    }

    private class Room{
        int start, end, room;
        Room(int s, int e, int room){
            this.room = room;
            this.start = s;
            this.end = e;
        }
        public String toString(){
            return start+": "+end+": "+room;
        }
    }

}
