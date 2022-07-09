package com.company.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TeamRanking {
    public String rankTeams(String[] v) {
        Team[] c = new Team[26];
        for(int i=0;i<26;i++){
            c[i] = new Team((char)('A'+i));
        }

        for(int i=0;i<v.length;i++){
            countChar(c, v[i]);
        }

        Arrays.sort(c, (a, b)->{
            for(int j =0;j<26;j++){
                if(a.i[j] != b.i[j])
                    return b.i[j] - a.i[j]; // descending so b-a
            }
            // if every votes matches then team name A comes before B
            // this will be ascending so a-b
            return a.c - b.c;
        });
        // now sorting is done
        Set<Character> s = new HashSet<>();
        for(int i=0;i<v[0].length();i++){
            s.add(v[0].charAt(i));
        }
        String ans = "";
        for(Team t : c){
            if(s.contains(t.c)){
                ans += t.c;
            }
        }
        return ans;

    }

    public void countChar(Team[] c, String s){
        for(int i =0;i< s.length();i++){
            c[s.charAt(i) - 'A'].i[i]++;
        }
    }

    class Team{
        char c;
        int[] i;
        Team(char c){
            this.c = c; // alphabet
            this.i = new int[26]; // count
        }
    }
}
