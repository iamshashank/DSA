package com.company.linkedlist;

import java.util.Stack;

/**
 * 92. Reverse Linked List II
 * Medium
 *
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 *
 * Example 2:
 *
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the list is n.
 *     1 <= n <= 500
 *     -500 <= Node.val <= 500
 *     1 <= left <= right <= n
 */

public class ReverseLinkedList_II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 1;
        ListNode lRoot = null, lTail = null;
        ListNode rRoot = null, rTail = null;
        ListNode mRoot = null, mTail = null;
        ListNode t = head;
        if(i == left){
            // left chain has no element
            mRoot = t;
        }else{
            lRoot = t;
            while(i+1 != left){
                t = t.next;
                i++;
            }
            lTail = t;
            mRoot = t.next;
            i++;
            // now cut the chain
            t.next = null;
        }

        // now figure out the middle chain
        ListNode mt = mRoot;
        if(i == right){
            mTail = mt;
            rRoot = mTail.next;
            // cut the chain
            mTail.next = null;
        }else{
            while(i != right) {
                mt = mt.next;
                i++;
            }
            mTail = mt;
            if(mt != null){
                rRoot = mt.next;
                // cut the chain
                mt.next = null;
            }
        }


        mt = null;
        Stack<ListNode> s = new Stack<>();

        while(mRoot != null){
            mt = mRoot;
            mRoot = mRoot.next;
            mt.next = null;
            s.push(mt);
        }
        if(lTail == null){
            head = s.pop();
            lTail = head;
        }
        while(!s.isEmpty()){
            lTail.next = s.pop();
            lTail = lTail.next;
        }
        lTail.next = rRoot;
        return head;
    }

    private class ListNode{
        ListNode next;
        int val;
    }
}
