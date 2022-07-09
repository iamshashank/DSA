package com.company.hash;

import java.util.HashMap;

/**
 * 911. Online Election
 * Medium
 *
 * You are given two integer arrays persons and times. In an election, the ith vote was cast for persons[i] at time times[i].
 *
 * For each query at a time t, find the person that was leading the election at time t. Votes cast at time t will count towards our query. In the case of a tie, the most recent vote (among tied candidates) wins.
 *
 * Implement the TopVotedCandidate class:
 *
 *     TopVotedCandidate(int[] persons, int[] times) Initializes the object with the persons and times arrays.
 *     int q(int t) Returns the number of the person that was leading the election at time t according to the mentioned rules.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
 * [[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [24], [8]]
 * Output
 * [null, 0, 1, 1, 0, 0, 1]
 *
 * Explanation
 * TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]);
 * topVotedCandidate.q(3); // return 0, At time 3, the votes are [0], and 0 is leading.
 * topVotedCandidate.q(12); // return 1, At time 12, the votes are [0,1,1], and 1 is leading.
 * topVotedCandidate.q(25); // return 1, At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
 * topVotedCandidate.q(15); // return 0
 * topVotedCandidate.q(24); // return 0
 * topVotedCandidate.q(8); // return 1
 *
 */

public class TopVotedCandidate {

    public HashMap<Integer, Integer> map = new HashMap<>();
    int[] personsTotalVote = new int[5000];
    int winningPersonIndex = 0;
    int max = 0;
    public TopVotedCandidate(int[] persons, int[] times) {
        int l = persons.length;
        for(int i = 0;i<l;i++){
            personsTotalVote[persons[i]]++;
            if(personsTotalVote[persons[i]] >= max){
                max = personsTotalVote[persons[i]];
                winningPersonIndex = persons[i];
            }

            map.put(times[i], winningPersonIndex);
        }
    }

    public int q(int t) {
        for(int i = t;i>=0;i--){
            if(map.containsKey(i)){
                return map.get(i);
            }
        }
        return 0;
    }
}
