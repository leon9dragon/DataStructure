package com.leetcode.linkedlist_problem.p0206;

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


public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode l1, l2, l3, l4;
        l4 = new ListNode(4);
        l3 = new ListNode(3, l4);
        l2 = new ListNode(2, l3);
        l1 = new ListNode(1, l2);

        ListNode originalHead = l1;

        while (originalHead != null) {
            System.out.printf("[%d] ", originalHead.val);
            originalHead = originalHead.next;
        }

        ListNode res = new ReverseLinkedList().reverseList(l1);

        while (res != null) {
            System.out.printf("[%d] ", res.val);
            res = res.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode last = null,
                temp = null;

        while (head != null) {
            temp = head;
            head = head.next;
            temp.next = last;
            last = temp;
        }

        return last;
    }

}
