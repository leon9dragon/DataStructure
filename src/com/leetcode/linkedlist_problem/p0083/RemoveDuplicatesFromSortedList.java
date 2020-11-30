package com.leetcode.linkedlist_problem.p0083;

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

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode l1, l2, l3, l4, l5;
        l5 = new ListNode(3);
        l4 = new ListNode(3, l5);
        l3 = new ListNode(2, l4);
        l2 = new ListNode(1, l3);
        l1 = new ListNode(1, l2);

        new RemoveDuplicatesFromSortedList().deleteDuplicates(l1);

        while (l1 != null) {
            System.out.printf("[%d] ", l1.val);
            l1 = l1.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode ptr1, ptr2;
        ptr1 = head.next;
        ptr2 = head;
        ptr2.next = null;

        while (ptr1 != null) {
            if (ptr1.val != ptr2.val) {
                ptr2.next = ptr1;
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
                ptr2.next = null;
            } else ptr1 = ptr1.next;
        }

        return head;
    }
}
