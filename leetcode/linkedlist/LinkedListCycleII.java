package com.company.leetcode.linkedlist;

import com.company.leetcode.linkedlist.helper.ListNode;
import com.company.leetcode.linkedlist.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LinkedListCycleII {
}

class SolutionLLC {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (fast == null || fast.next == null)
            return null;
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

class SolutionFN {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode f = dummy;
        ListNode s = dummy;
        for (int i = 1; i <= n + 1; i++) {
            f = f.next;
        }
        while (f != null) {
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return dummy.next;
    }
}




class SolutionALB {

    List<Double> list = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null)
            return list;
        double avg = 0;
        averageOfLevels(root.left);
        avg += root.val;
        averageOfLevels(root.left);
        avg += root.val;
        list.add(avg);
        return null;
    }
}
