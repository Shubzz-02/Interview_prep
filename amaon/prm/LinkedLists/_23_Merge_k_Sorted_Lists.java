package com.company.amaon.prm.LinkedLists;

import java.util.PriorityQueue;

public class _23_Merge_k_Sorted_Lists {

    public static void main(String[] args) {

    }

    private static class Pair implements Comparable<Pair> {

        int val;
        int list;
        ListNode pointer;

        public Pair(int val, int ind, ListNode li) {
            this.val = val;
            this.list = ind;
            this.pointer = li;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val = o.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode sortedNode = null;
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < lists.length; i++) {
            pq.add(new Pair(lists[i].val, i, lists[0]));
        }

        sortedNode = new ListNode();

        while (pq != null) {
            Pair p = pq.remove();
            sortedNode.next = p.pointer;
            p.pointer = lists[p.list].next;
            if (p.pointer != null) {
                pq.add(new Pair(lists[p.list].next.val, p.list, lists[p.list].next));
            }
        }
        return null;
    }

}
