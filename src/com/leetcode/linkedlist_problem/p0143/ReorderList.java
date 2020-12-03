package com.leetcode.linkedlist_problem.p0143;

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


public class ReorderList {
    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        int count = 0;
        ListNode ptr = head;
        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }

        int re_inedx;
        if (count % 2 == 0) {
            re_inedx = count / 2 + 1;
        } else {
            re_inedx = count / 2 + 2;
        }
        count = 1;
    }
}
