package com.company.leetcode.march;

public class IntersectionOfTwoLinkedLists {
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class SolutionIOTLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ap = headA, bp = headB;
        int ac = 0, bc = 0;
        while (ap != null && bp != null) {
            if (ap == bp)
                return ap;
            else {
                ap = ap.next;
                bp = bp.next;
            }
            if (ac < 2 && ap == null) {
                ac++;
                ap = headB;
            }
            if (bc < 2 && bp == null) {
                bc++;
                bp = headA;
            }
        }
        return null;
    }
}
