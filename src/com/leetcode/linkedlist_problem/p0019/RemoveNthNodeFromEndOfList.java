package com.leetcode.linkedlist_problem.p0019;

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


public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode ptr = head;
        while (ptr != null) {
            stack.push(ptr);
            ptr=ptr.next;
        }

        int count = 0;
        ListNode next = null;
        while(!stack.empty()){
            count++;
            if(count==n){
                stack.pop();
                if(!stack.empty()) stack.pop().next = next;
                else return next;
            }else{
                next = stack.pop();
            }
        }

        return head;
    }
}
