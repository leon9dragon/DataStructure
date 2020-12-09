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

        ListNode ptr;
        ListNode cur = head;
        int curVal, temp;
        int size = 0;

        while (cur != null) {
            size++;
            curVal = cur.val;
            temp = cur.val;
            ptr = cur.next;
            while (ptr != null) {
                if (ptr.val > curVal) {
                    curVal = ptr.val;
                    break;
                }
                ptr = ptr.next;
            }
            if (temp == curVal) curVal = 0;

            cur = cur.next;
        }

        int[] ret = new int[size];

        return ret;
    }
}
