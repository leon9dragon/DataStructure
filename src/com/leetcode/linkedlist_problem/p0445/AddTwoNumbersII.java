package com.leetcode.linkedlist_problem.p0445;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Stack;

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


public class AddTwoNumbersII {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode temp = null;
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        int carry_bit = 0;
        int sum;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                s1.push(l1);
                l1 = l1.next;
            }
            if (l2 != null) {
                s2.push(l2);
                l2 = l2.next;
            }
        }

        while (!s1.empty() || !s2.empty()) {
            sum = 0;
            if (!s1.empty()) sum += s1.pop().val;
            if (!s2.empty()) sum += s2.pop().val;
            sum += carry_bit;
            carry_bit = 0;

            if (sum >= 10) {
                sum %= 10;
                carry_bit = 1;
            }

            temp = new ListNode(sum);
            temp.next = l3;
            l3 = temp;
        }

        if (carry_bit == 1) {
            temp = new ListNode(1);
            temp.next = l3;
            l3 = temp;
        }

        return l3;
    }
}
