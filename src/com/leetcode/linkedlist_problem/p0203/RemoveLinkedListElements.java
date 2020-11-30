package com.leetcode.linkedlist_problem.p0203;

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

public class RemoveLinkedListElements {
    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode ptr1 = head;
        ListNode ptr2 = null;
        ListNode newHead = null;

        while (ptr1 != null) {
            if (ptr1.val != val) {
                if (ptr2 == null) {
                    ptr2 = ptr1;
                    newHead = ptr2;
                } else {
                    ptr2.next = ptr1;
                    ptr2 = ptr2.next;
                }
                ptr1 = ptr1.next;
                ptr2.next = null;
            } else ptr1 = ptr1.next;
        }

        return newHead;
    }
}
