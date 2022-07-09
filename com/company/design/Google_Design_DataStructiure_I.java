package com.company.design;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Google_Design_DataStructiure_I {
    private class CustomList{
        private HashMap<Long, Long> indexMap;
        private TreeMap<Long, PriorityQueue<Long>> smallestIndexMap;
        CustomList(){
            indexMap = new HashMap<>();
            smallestIndexMap = new TreeMap<>();
        }

        public void insertOrReplace(long i, long a){
            Long prevEl = indexMap.getOrDefault(i, null);
            if(prevEl != null ){
                smallestIndexMap.get(prevEl).remove(i);
            }
            indexMap.put(i, a);
            PriorityQueue<Long> q = smallestIndexMap.getOrDefault(a, new PriorityQueue<>());
            q.add(i);
            smallestIndexMap.put(a, q);
        }

        public long findSmallestIndex(long a){
            PriorityQueue<Long> q = smallestIndexMap.getOrDefault(a, null);
            if(q == null) return -1;
            return q.peek();
        }
    }

    public void setup(){
        CustomList list = new CustomList();
        list.insertOrReplace(2, 100);
        list.insertOrReplace(1, 100);
        list.insertOrReplace(3, 100);
        list.insertOrReplace(5, 100);
        System.out.println(list.findSmallestIndex(100));
        list.insertOrReplace(1, 200);
        System.out.println(list.findSmallestIndex(100));
        System.out.println(list.findSmallestIndex(200));

    }
}
