package com.company.etc;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergerKSOrtedArray {
}

class SolutionAMAz {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                new Comparator<SolutionAMAz.ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        return o1.val - o2.val;
                    }
                }
        );
        for (ListNode li : lists)
            if (li != null)
                pq.add(li);

        ListNode head = null, tail = null;

        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            if (top.next != null)
                pq.add(top.next);
            if (head == null) {
                head = top;
                tail = top;
            } else {
                tail.next = top;
                tail = top;
            }
        }
        return head;
    }
}

