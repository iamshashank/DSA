package com.company.dfs;

import java.util.*;

/**
 * You are given various statements regarding some points and the direction between them. Check if all the statements are correct or not.
 *
 * For example:
 *
 * P1 is in North of P2
 * P2 is in North of P3
 * P3 is in North of P1
 *
 * Output: False (since P3 will be in South of P1)
 *
 * Directions can be N,S,W,E,NW,NE,SW, etc.
 * The interviewer gave the hint to use graph.
 */
public class Google_VerifyTheRules {
    HashMap<String, List<String>> northSouth;
    HashMap<String, List<String>> eastWest;

    Set<String> v;
    public boolean checkIfValid(String[] rules){
        northSouth = new HashMap<>();
        eastWest = new HashMap<>();

        v = new HashSet<>();
        for(String rule : rules){
            String[] r = rule.split(" ");
            if(!northSouth.containsKey(r[0])) northSouth.put(r[0], new ArrayList<>());
            if(!northSouth.containsKey(r[2])) northSouth.put(r[2], new ArrayList<>());
            if(!eastWest.containsKey(r[0])) eastWest.put(r[0], new ArrayList<>());
            if(!eastWest.containsKey(r[2])) eastWest.put(r[2], new ArrayList<>());
            if(r[1].equals("N")){
                northSouth.get(r[0]).add(r[2]);
            } else if (r[1].equals("S")) {
                northSouth.get(r[2]).add(r[0]);
            } else if (r[1].equals("E")) {
                eastWest.get(r[2]).add(r[0]);
            }else if (r[1].equals("W")) {
                eastWest.get(r[0]).add(r[2]);
            }else if (r[1].equals("NE")) {
                northSouth.get(r[0]).add(r[2]);
                eastWest.get(r[2]).add(r[0]);
            }else if (r[1].equals("NW")) {
                northSouth.get(r[0]).add(r[2]);
                eastWest.get(r[0]).add(r[2]);
            }else if (r[1].equals("SE")) {
                northSouth.get(r[2]).add(r[0]);
                eastWest.get(r[2]).add(r[0]);
            }else if (r[1].equals("SW")) {
                northSouth.get(r[2]).add(r[0]);
                eastWest.get(r[0]).add(r[2]);
            }
        }
        System.out.println(northSouth);
        return (detectCycle(northSouth) || detectCycle(eastWest) ? false : true);
    }

    boolean detectCycle(HashMap<String, List<String>> adj){
        for(String node : adj.keySet()){
            v.clear();
            if(dfs(node, adj)) return true;
        }
        return false;
    }

    boolean dfs(String node, HashMap<String, List<String>> adj){
        if(v.contains(node)) return true;
        v.add(node);
        for(String n : adj.get(node)){
            if(dfs(n, adj)) return true;
        }
        // we need to backtrack since this is directed graph
        v.remove(node);
        return false;
    }
}
