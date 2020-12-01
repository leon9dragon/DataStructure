package com.leetcode.linkedlist_problem.p0876;

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


public class MiddleOfTheLinkedList {
    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {
        int count = -1;
        ListNode ptr = head;
        while (head != null) {
            count++;
            head = head.next;
        }
        int midIndex;
        if ((count + 1) % 2 == 0) midIndex = count / 2 + 1;
        else midIndex = count / 2;

        count = -1;
        while (count != midIndex - 1) {
            count++;
            ptr = ptr.next;
        }

        return ptr;
    }
}
