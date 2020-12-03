package com.leetcode.linkedlist_problem.p0092;

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


public class ReverseLinkedListII {
    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) return head;
        ListNode tempHead = new ListNode(0, head);
        ListNode bp1 = tempHead;
        ListNode bp2 = null;

        ListNode ptr = head;
        ListNode next = null;
        ListNode temp = null;

        int count = 1;
        while (count <= n) {
            if (count < m) {
                bp1 = bp1.next;
                ptr = ptr.next;
            } else {
                if (count == m) bp2 = ptr;
                
                temp = ptr.next;
                ptr.next = next;
                next = ptr;

                if (count == n) {
                    bp2.next = temp;
                    bp1.next = ptr;
                    break;
                }

                ptr = temp;
            }
            count++;
        }

        return tempHead.next;
    }
}
