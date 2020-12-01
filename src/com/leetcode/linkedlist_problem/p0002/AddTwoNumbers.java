package com.leetcode.linkedlist_problem.p0002;

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


public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode a1, a2, a3, a4, a5;
        ListNode b1, b2, b3;

        a5 = new ListNode(9);
        a4 = new ListNode(9, a5);
        a3 = new ListNode(9, a4);
        a2 = new ListNode(9, a3);
        a1 = new ListNode(9, a2);

        b3 = new ListNode(1);
        b2 = new ListNode(1, b3);
        b1 = new ListNode(1, b2);

        ListNode c1 = new AddTwoNumbers().addTwoNumbers(a1, b1);
        while (c1 != null) {
            System.out.printf("[%d] ", c1.val);
            c1 = c1.next;
        }
        /*ListNode l1 = new ListNode(0);
        ListNode l2 = null;
        System.out.println(l1 != null || l2 != null);*/
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry_bit = 0;
        int sum;
        ListNode l3 = null;
        ListNode last = null;

        while (l1 != null || l2 != null) {
            sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry_bit;
            carry_bit = 0;

            if (sum >= 10) {
                sum %= 10;
                carry_bit = 1;
            }

            if (l3 == null) {
                l3 = new ListNode(sum);
                last = l3;
            } else {
                last.next = new ListNode(sum);
                last = last.next;
            }
        }

        if (carry_bit == 1) {
            last.next = new ListNode(1);
        }

        return l3;
    }
}
