package com.leetcode.linkedlist_problem.p0328;

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


public class OddEvenLinkedList {
    public static void main(String[] args) {

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd_ptr = head;
        ListNode even_ptr = head.next;
        ListNode link = head.next;
        ListNode temp = null;

        while (true) {
            temp = even_ptr.next;
            if (temp == null) break;
            odd_ptr.next = temp;
            odd_ptr = temp;

            temp = odd_ptr.next;
            if (temp == null) break;
            even_ptr.next = temp;
            even_ptr = temp;
        }

        odd_ptr.next = link;
        even_ptr.next = null;

        return head;
    }
}
