package com.company.amaon.prm.LinkedLists;

public class _25_Reverse_Nodes_in_k_Group {

    public static void main(String[] args) {
        ListNode l = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, null)))))));
        ListNode rev = new _25_Reverse_Nodes_in_k_Group().reverseKGroup(l, 3);
        while (rev != null) {
            System.out.print(rev.val);
            if (rev.next != null) {
                System.out.print(" --> ");
            }
            rev = rev.next;
        }
        System.out.println();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode new_head = null, tail = null;
        while (temp != null) {
            ListNode lf = temp;
            int i = 0;
            while (lf != null && i < k) {
                lf = lf.next;
                i++;
            }
            if (i == k) {
                ListNode revNode = reverseList(temp, lf);
                if (new_head == null) {
                    new_head = revNode;
                }
                if (tail != null) {
                    tail.next = revNode;
                }
            }
            tail = temp;
            temp = lf;
        }
        return new_head;
    }

    private ListNode reverseList(ListNode temp, ListNode lf) {

        ListNode prev = lf;
        ListNode curr = temp;
        while (curr != lf) {
            ListNode nn = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nn;
        }
        temp = prev;

        return temp;
    }

}
