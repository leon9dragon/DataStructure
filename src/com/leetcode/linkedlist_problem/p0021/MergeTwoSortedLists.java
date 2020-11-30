package com.leetcode.linkedlist_problem.p0021;


//Definition for singly-linked list.
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

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1, l12, l13, l2, l22, l23;
        l13 = new ListNode(4);
        l12 = new ListNode(2, l13);
        l1 = new ListNode(1, l12);

        l23 = new ListNode(1);
        l22 = new ListNode(1, l23);
        l2 = new ListNode(1, l22);

        ListNode res = new MergeTwoSortedLists().mergeTwoLists(l1, l2);
        while (res != null) {
            System.out.printf("[%d] ", res.val);
            res = res.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //situation for one or two list is null
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        //define and init the pointers and temp var
        ListNode ptr1, ptr2, temp;
        ptr1 = l1;
        ptr2 = l2;
        temp = null;

        //when one pointer is pointed out of the list's bound we should end the loop
        while (ptr1 != null && ptr2 != null) {
            //get the point from list2 which can be linked to the ptr1 if that's all right
            while (ptr2 != null && ptr1.val >= ptr2.val) {
                temp = ptr2;
                ptr2 = ptr2.next;
            }
            //if temp is not null prove that the loop has been run
            //we should change the link of the point pointed by temp
            if (temp != null && temp.val <= ptr1.val) {
                temp.next = ptr1;
                //reset
                temp = null;
            }

            //if ptr2 is null prove that all the points from list2 have been linked to list1's points
            if (ptr2 == null) break;

            while (ptr1 != null && ptr2.val >= ptr1.val) {
                temp = ptr1;
                ptr1 = ptr1.next;
            }
            if (temp != null && temp.val <= ptr2.val) {
                temp.next = ptr2;
                temp = null;
            }
        }

        //return the new list's head
        return l1.val >= l2.val ? l2 : l1;
    }
}


