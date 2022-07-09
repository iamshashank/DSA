package com.company.priorityqueue_heap;

import java.util.PriorityQueue;

/**
 *23. Merge k Sorted Lists
 * Hard
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 *
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 *
 *
 * Constraints:
 *
 *     k == lists.length
 *     0 <= k <= 104
 *     0 <= lists[i].length <= 500
 *     -104 <= lists[i][j] <= 104
 *     lists[i] is sorted in ascending order.
 *     The sum of lists[i].length will not exceed 104
 *
 */

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b)->{
            return a.val-b.val;
        });
        for(ListNode n : lists) {
            if(n != null) q.add(n);
        }
        ListNode root = null;
        ListNode itr = null;
        while(!q.isEmpty()){
            ListNode node = q.remove();
            ListNode t = node.next;
            node.next = null;
            if(root == null) {
                root = node;
                itr = root;
            }else{
                itr.next = node;
                itr = itr.next;
            }
            if(t != null) q.add(t);
        }
        return root;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
