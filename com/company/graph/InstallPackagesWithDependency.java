package com.company.graph;

import java.util.*;

public class InstallPackagesWithDependency {
    public List<Character> process(Map<Character, Character[]> input, Character start){
        Set<Character> visited = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();
        List<Character> res = new ArrayList<>();

        queue.add(start);
        visited.add(start);
        Character node = start;
        while(!queue.isEmpty()){
            node = queue.remove();
//            res.add(node);
            res.add(0, node); // so we dont have to reverse at the end
            Character[] arr = input.get(node); // adjacency list of `node`
            if(arr == null || arr.length == 0){
                continue;
            }else{
                for(int i = 0; i < arr.length; i++){
                    if(!visited.contains(arr[i])) {
                        visited.add(arr[i]);
                        queue.add(arr[i]);
                    }
                }
            }
        }
        return res;
    }

    /**
     * USING TOPOLOGICAL SORT
     *
     * @return
     */
    HashSet<Character> visited = new HashSet<>();
    ArrayList<Character> res = new ArrayList<>();
    public List<Character> topoProcess(HashSet<Character> packagesToInstall, HashMap<Character, Character[]> adj, char c){

        topoLogicalSort(adj, c); // start from the given package
        // after that we pick a unvisited package and process this till all packages are in our res
        while(res.size() < packagesToInstall.size()){
            // pick a unvisited package
            for(char a = 'A'; a<= 'Z'; a++){
                if(packagesToInstall.contains(a) && !visited.contains(a)){
                    topoLogicalSort(adj, a);
                }
            }
        }
        return res;
    }
    public void topoLogicalSort(HashMap<Character, Character[]> adj, char c){
        if(visited.contains(c)) return;
        visited.add(c);
        Character[] connectedNodes = adj.get(c);
        if(connectedNodes != null){
            for (Character n : adj.get(c)){
                topoLogicalSort(adj, n);
            }
        }
        // after visting all child nodes or dependencies in depth add to our result
        res.add(c); // so we dont have to reverse

        return;
    }




    public String setup(){
        // adjacency list
        HashMap<Character, Character[]> map = new HashMap<>();
//        map.put('A', new Character[]{'B'});
//        map.put('B', new Character[]{'C', 'D'});
//        map.put('C', new Character[]{'E'});
//        map.put('D', new Character[]{'F'});
//        map.put('E', new Character[]{'F'});
//        List<Character> l= process(map, 'B');

        map.put('A', new Character[]{'B', 'C'});
        map.put('B', new Character[]{'D', 'E', 'F'});
        map.put('C', new Character[]{'F'});
        map.put('F', new Character[]{'G'});
        map.put('H', new Character[]{'I', 'J'});
        map.put('J', new Character[]{'G'});
        HashSet<Character> packagesToInstall = new HashSet<>();
        packagesToInstall.add('A');
        packagesToInstall.add('B');
        packagesToInstall.add('C');
        packagesToInstall.add('D');
        packagesToInstall.add('E');
        packagesToInstall.add('F');
        packagesToInstall.add('G');
        packagesToInstall.add('H');
        packagesToInstall.add('I');
        packagesToInstall.add('J');
        List<Character> l= topoProcess(packagesToInstall, map, 'B');

        return l.toString();
    }
}
