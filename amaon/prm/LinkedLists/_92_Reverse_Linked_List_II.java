package com.company.amaon.prm.LinkedLists;

public class _92_Reverse_Linked_List_II {

    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int l, int r) {
        if (head == null) {
            return null;
        }
        ListNode cur = head, prev = null;
        while (l > 1) {
            prev = cur;
            cur = cur.next;
            l--;
            r--;
        }
        ListNode con = prev, tail = cur;
        ListNode third = null;
        while (r > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            r--;
        }
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;

    }
}
