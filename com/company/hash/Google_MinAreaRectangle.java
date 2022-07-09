package com.company.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Google_MinAreaRectangle {
    public int minAreaRect(int[][] points) {
        // key will be `x` coordinate ans value will be a Set if all `y` for quick search
        // with 2 loops we will pick 2 points and since we need to form a rectangle we will mathamatically generate the other 2 points
        // if the 2 points selected have same X or same Y then generating other 2 points not possible so skip that combo
        // then just gen the points and calculate the Area
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int[] p : points){
            int x = p[0];
            int y = p[1];
            if(!map.containsKey(x)){
                map.put(x, new HashSet<>());
            }
            map.get(x).add(y);
        }

        for(int[] p1 : points){
            for(int[] p2: points){
                // you cannot generate the other 2 points
                if(p1[0] == p2[0] || p1[1] == p2[1]) continue;

                int[] p3 = new int[]{p1[0], p2[1]};
                int[] p4 = new int[]{p2[0], p1[1]};

                // this points is not int the input
                if(!map.get(p1[0]).contains(p2[1]) || !map.get(p2[0]).contains(p1[1])) continue;

                int area = Math.abs(p1[0]-p4[0])*Math.abs(p1[1]-p3[1]);
                min = Math.min(min, area);

            }
        }
        return (min != Integer.MAX_VALUE) ? min : 0;
    }
}
