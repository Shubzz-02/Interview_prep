package com.company.leetcode.easy;


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
}

class SolutionPLL {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;
        slow = reverse(slow);

        while (slow != null) {
            if (slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prevNode = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        return prevNode;
    }
}
/*
  ______    _______      _______     _______     _______
  | 1 |  |-> | 2 |  | ->  | 3 |  | -> | 4 |  | -> | 5 |  | -> null
  -------
 */
