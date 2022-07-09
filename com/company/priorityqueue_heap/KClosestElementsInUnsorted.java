package com.company.priorityqueue_heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestElementsInUnsorted {
    public String process(int[] a, int k, int x){
        int[] res = new int[k];
        PriorityQueue pq = new PriorityQueue<Element>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o2.diff - o1.diff;
            }
        });
        for(int i = 0; i< a.length; i++){
            Element e = new Element(Math.abs(x-a[i]), a[i]);
            if(i < k){
                pq.add(e);
            } else {
              if(e.diff < ((Element) pq.peek()).diff){
                  // we remove the top of queue and add this to pq
                  pq.poll();
                  pq.add(e);
              }
            }
        }
        Element tmp;
        int i = 0;
        while (!pq.isEmpty()){
            tmp = (Element) pq.poll();
            res[i++] = tmp.el;
        }
        return Arrays.toString(res);
    }

    class Element {
        int diff, el;
        Element(int diff, int el){
            this.diff = diff;
            this.el = el;
        }
    }
}
