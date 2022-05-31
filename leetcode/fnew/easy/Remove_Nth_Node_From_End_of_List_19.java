package com.company.leetcode.fnew.easy;

public class Remove_Nth_Node_From_End_of_List_19 {

    public static void main(String[] args) {
        ListNode l = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode remove = new Remove_Nth_Node_From_End_of_List_19().removeNthFromEnd(l, 2);
        while (remove != null) {
            if (remove.next != null) {
                System.out.print(remove.val + " --> ");
            } else {
                System.out.println(remove.val + " --_");
            }
            remove = remove.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

