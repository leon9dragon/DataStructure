package com.leetcode.linkedlist_problem.p1019;


import java.util.ArrayList;

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


public class NextGreaterNodeInLinkedList {
    public static void main(String[] args) {

    }

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) return new int[0];
        if (head.next == null) return new int[]{0};

        
    }
}
