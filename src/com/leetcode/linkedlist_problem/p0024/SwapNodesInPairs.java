package com.leetcode.linkedlist_problem.p0024;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;

        ListNode last = head;
        ListNode next = head.next;
        ListNode temp1, temp2 = null;

        while (next != null) {
            temp1 = next.next;
            next.next = last;
            last.next = temp1;
            //temp1 store next.next while temp2 store last.last
            if (temp2 != null) temp2.next = next;
            temp2 = last;

            last = last.next;
            if (last == null || last.next == null) break;
            next = last.next;
        }

        return newHead;
    }
}
