package com.company.linkedlist;

/**
 *
 * 2. Add Two Numbers
 * Medium
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 */

public class Add2Number {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode t1 = l1, t2 = l2, ans = null, t = null;
        while(t1 != null && t2 != null){
            int x = t1.val+t2.val + carry;
            carry = x/10;
            x = x%10;
            if(ans == null){
                t = new ListNode(x);
                ans = t;
            }else{
                t.next = new ListNode(x);
                t = t.next;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        while(t1 != null){
            int x = t1.val + carry;
            carry = x/10;
            x = x%10;
            t.next = new ListNode(x);
            t = t.next;
            t1 = t1.next;
        }
        while(t2 != null){
            int x = t2.val + carry;
            carry = x/10;
            x = x%10;
            t.next = new ListNode(x);
            t = t.next;
            t2 = t2.next;
        }
        if(carry > 0){
            t.next = new ListNode(carry);
        }
        return ans;
    }

     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

}
