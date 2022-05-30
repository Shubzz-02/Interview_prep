package com.company.leetcode.fnew.easy;

public class Middle_of_Linked_List_876 {

    public static void main(String[] args) {
        ListNode l = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
        ListNode mid = new Middle_of_Linked_List_876().middleNode(l);
        while (mid != null) {
            System.out.println(mid.val);
            mid = mid.next;
        }

    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

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
