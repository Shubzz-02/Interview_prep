package com.company.leetcode.fnew.easy;

public class Reverse_Linked_List_206 {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
    }

}
