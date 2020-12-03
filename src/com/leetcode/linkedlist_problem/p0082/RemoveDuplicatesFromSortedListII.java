package com.leetcode.linkedlist_problem.p0082;

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


public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode tempHead = new ListNode(Integer.MIN_VALUE, head);

        ListNode last = tempHead;
        ListNode curr = head;

        if (head == null || head.next == null) return head;

        ListNode next = head.next;

        while (next != null) {
            if (next.val != curr.val) {
                last = curr;
            } else {
                while (next != null && curr.val == next.val) {
                    next = next.next;
                }
                last.next = next;
                if (next == null) break;
            }
            curr = next;
            next = next.next;
        }

        return tempHead.next;
    }
}
