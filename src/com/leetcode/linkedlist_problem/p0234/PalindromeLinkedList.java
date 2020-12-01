package com.leetcode.linkedlist_problem.p0234;

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


public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode l1, l2, l3, l4;
        l4 = new ListNode(2);
        l3 = new ListNode(1, l4);
        l2 = new ListNode(2, l3);
        l1 = new ListNode(1, l2);

        boolean res = new PalindromeLinkedList().isPalindrome(l1);
        System.out.println(res);
    }

    public boolean isPalindrome(ListNode head) {
        int count = -1;
        int end_of_front, start_of_back;

        ListNode ptr = head;

        while (head != null) {
            count++;
            head = head.next;
        }

        if (count == -1 || count == 0) return true;

        if ((count + 1) % 2 == 0) {
            end_of_front = count / 2;
            start_of_back = count / 2 + 1;
        } else {
            end_of_front = count / 2 - 1;
            start_of_back = count / 2 + 1;
        }

        count = -1;
        ListNode temp = null, last = null;
        while (count != end_of_front) {
            count++;
            temp = ptr;
            ptr = ptr.next;
            temp.next = last;
            last = temp;
        }

        while (ptr != null) {
            count++;
            if (count >= start_of_back) {
                if (last.val != ptr.val) return false;
                last = last.next;
            }
            ptr = ptr.next;
        }
        return true;
    }
}
