package com.leetcode.linkedlist_problem.p0142;

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


public class LinkedListCycleII {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode t = head;
        ListNode h = head;

        do {
            t = t.next;
            if (t == null) return null;
            h = h.next;
            if (h == null) return null;
            h = h.next;
            if (h == null) return null;
        } while (t != h);

        t = head;
        while (t != h) {
            t = t.next;
            h = h.next;
        }

        return t;
    }
}
