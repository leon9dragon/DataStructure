package com.leetcode.linkedlist_problem.p0143;

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


public class ReorderList {
    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        Stack<ListNode> listReverse = new Stack<>();
        ListNode ptr = head;
        while (ptr != null) {
            listReverse.push(ptr);
            ptr = ptr.next;
        }

        int nodeCount = listReverse.size();
        int moveCount = nodeCount - (nodeCount / 2 + 1);

        ListNode temp = null;
        ListNode next = null;
        ptr = head;

        while (moveCount > 0) {
            temp = listReverse.pop();
            next = ptr.next;
            ptr.next = temp;
            temp.next = next;
            ptr = next;
            moveCount--;
        }
        
        while (ptr.next != temp) {
            ptr = ptr.next;
        }
        ptr.next = null;
    }
}
