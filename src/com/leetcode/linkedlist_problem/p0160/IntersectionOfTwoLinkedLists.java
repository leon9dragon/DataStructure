package com.leetcode.linkedlist_problem.p0160;

import java.util.List;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headOfA = headA;
        ListNode res = null;
        while (headA != null) {
            headA.val *= -1;
            headA = headA.next;
        }

        while (headB != null) {
            if (headB.val < 0) {
                res = headB;
                break;
            } else {
                headB = headB.next;
            }
        }

        while (headOfA != null) {
            headOfA.val *= -1;
            headOfA = headOfA.next;
        }

        return res;
    }
}
