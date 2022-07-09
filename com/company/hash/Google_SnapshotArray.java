package com.company.hash;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 1146. Snapshot Array
 * Medium
 *
 * Implement a SnapshotArray that supports the following interface:
 *
 *     SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
 *     void set(index, val) sets the element at the given index to be equal to val.
 *     int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
 *     int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
 *
 *
 *
 * Example 1:
 *
 * Input: ["SnapshotArray","set","snap","set","get"]
 * [[3],[0,5],[],[0,6],[0,0]]
 * Output: [null,null,0,null,5]
 * Explanation:
 * SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
 * snapshotArr.set(0,5);  // Set array[0] = 5
 * snapshotArr.snap();  // Take a snapshot, return snap_id = 0
 * snapshotArr.set(0,6);
 * snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
 *
 */

class Google_SnapshotArray {

    public HashMap<String, Integer> map;
    public int snap_id = 0;
    public Google_SnapshotArray(int length) {
        this.map = new HashMap<>();
    }

    public void set(int index, int val) {
        this.map.put(this.snap_id+"-"+index, val);
    }

    public int snap() {
        int i = this.snap_id;
        this.snap_id++;
        return i;
    }

    public int get(int index, int snap_id) {
        // this is main trick
        // suppose if want to find a[5] at snap_id = 2
        // if we did not update a[5] at snap_id 2 then its value will be what it was at snap-id = 1 if not then snap_id = 0 else it will be 0
        for(int i =snap_id;i>=0;i--){
            if(this.map.containsKey(i+"-"+index)) return this.map.get(i+"-"+index);
        }

        return 0;
    }
}





