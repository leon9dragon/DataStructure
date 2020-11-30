package com.leetcode.linkedlist_problem.p0141;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode l1, l2, l3, l4;
        l1 = new ListNode(1);
        l2 = new ListNode(1);
        l3 = new ListNode(1);
        l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l3;

        boolean res = new LinkedListCycle().hasCycle(l1);
        System.out.println(res);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode ptr = head;
        while (ptr != null) {
            if (ptr.val != Integer.MIN_VALUE) {
                ptr.val = Integer.MIN_VALUE;
                ptr = ptr.next;
            } else return true;
        }
        return false;
    }
}
