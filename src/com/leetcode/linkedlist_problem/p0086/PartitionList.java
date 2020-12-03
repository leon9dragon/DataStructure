package com.leetcode.linkedlist_problem.p0086;

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


public class PartitionList {
    public static void main(String[] args) {

    }

    public ListNode partition(ListNode head, int x) {
        ListNode newHead = null;

        ListNode breakPoint = new ListNode(0);
        ListNode last = null;
        ListNode next = null;


        while (head != null) {
            if (head.val < x) {
                if (last == null) {
                    last = head;
                    newHead = head;
                } else {
                    last.next = head;
                    last = last.next;
                }
                head = head.next;
                last.next = breakPoint;
            } else {
                if (next == null) {
                    breakPoint.next = head;
                    next = head;
                    head = head.next;
                } else {
                    next.next = head;
                    head = head.next;
                    next = next.next;
                }
                next.next = null;
            }
        }

        if (last == null) return breakPoint.next;
        if (next == null) {
            last.next = null;
            return newHead;
        }
        last.next = breakPoint.next;
        return newHead;
    }
}
