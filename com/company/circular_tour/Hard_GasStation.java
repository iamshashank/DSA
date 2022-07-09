package com.company.circular_tour;

/**
 * 134. Gas Station
 * Medium
 *
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
 *
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
 *
 *
 *
 * Example 1:
 *
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 *
 * Example 2:
 *
 * Input: gas = [2,3,4], cost = [3,4,3]
 * Output: -1
 * Explanation:
 * You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
 * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 0. Your tank = 4 - 3 + 2 = 3
 * Travel to station 1. Your tank = 3 - 3 + 3 = 3
 * You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
 * Therefore, you can't travel around the circuit once no matter where you start.
 *
 */

public class Hard_GasStation {
    // https://www.youtube.com/watch?v=lJwbPZGo05A

    public int canCompleteCircuit(int[] g, int[] c) {
        int l = g.length;
        // this problem is not very intuitive
        // 1st we verify if a solution exists if sum(costs) <= sum(gas) the possible
        int[] diff = new int[l];
        long sumG = 0, sumC =0;
        for(int i=0;i<l;i++){
            // the diff array will tell us that at pump `i` what will be out  NET fuel change
            diff[i] = g[i]-c[i];
            sumG += g[i];
            sumC += c[i];
        }
        if(sumC > sumG){
            return -1;
        }

        // so now we know a solution exists
        int fuelLeft = 0;
        int pumpIndex = 0; // lets say the ans is  index = 0
        for(int i = 0;i<l;i++){
            fuelLeft += diff[i];
            if(fuelLeft < 0){
                // solution not possible as our tank is empty
                fuelLeft = 0;
                // since pumpIndex did not work we can be sure that any pump from pumpindex till current i will also not work.
                // because there is a unique solution as mentioned in question and if we were able to reach the solution index pump from our wrong pump
                // then again we will be able to complete the circle, that means we can skip the pumpIndex....i pumps
                pumpIndex = i+1;
            }
        }
        return pumpIndex;
    }
}
