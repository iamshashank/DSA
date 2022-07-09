package com.company;

import java.util.PriorityQueue;
import java.util.Queue;

public class BathroomStalls {
    public String process(int n, int k) {
        final Queue<Stall> stalls = new PriorityQueue<>((o1, o2) -> {
            final int size1 = o1.nearestRight - o1.nearestLeft, size2 = o2.nearestRight - o2.nearestLeft;
            if (size1 != size2) {
                return size2 - size1;
            } else {
                return o1.nearestLeft - o2.nearestLeft;
            }
        });
        final StringBuilder sb = new StringBuilder();

        stalls.clear();
        stalls.add(new Stall(0, n + 1));
        int max = 0, min = 0;
        int middle = 0;
        for (int i = 0; i < k; i++) {
            final Stall largest = stalls.poll();
            middle = (largest.nearestRight + largest.nearestLeft) >> 1;
            stalls.add(new Stall(middle, largest.nearestRight));
            stalls.add(new Stall(largest.nearestLeft, middle));
            max = Math.max(largest.nearestRight - middle, middle - largest.nearestLeft) - 1;
            min = Math.min(largest.nearestRight - middle, middle - largest.nearestLeft) - 1;
        }
        sb.append("BathroomStall Last person will occupy index = ").append(middle);
        return sb.toString();
    }

    private class Stall {
        final int nearestLeft, nearestRight;

        Stall(final int nearestLeft, final int nearestRight) {
            this.nearestLeft = nearestLeft;
            this.nearestRight = nearestRight;
        }

        @Override
        public String toString() {
            return "{L=" + nearestLeft + ", R=" + nearestRight + "}";
        }
    }

}
