package com.leetcode.linkedlist_problem.p1290;

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


public class ConvertBinaryNumberInLinkedList2Integer {
    public static void main(String[] args) {

    }

    public int getDecimalValue(ListNode head) {
        int val = 0;
        ListNode ptr = head;

        int count = -1;
        while (head != null) {
            count++;
            head = head.next;
        }
        while (count >= 0) {
            val += ptr.val * Math.pow(2, count);
            count--;
            ptr = ptr.next;
        }

        return val;
    }
}
