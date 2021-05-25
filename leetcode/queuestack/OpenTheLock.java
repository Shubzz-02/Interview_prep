package com.company.leetcode.queuestack;

import java.util.*;

public class OpenTheLock {
    public static void main(String[] args) {
        System.out.println(new SolutionOTL().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }
}

class SolutionOTL {
    public int openLock(String[] deadEnds, String target) {
        int[][] comb = new int[][]{
                {1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1},
                {-1, 0, 0, 0}, {0, -1, 0, 0}, {0, 0, -1, 0}, {0, 0, 0, -1}
        };
        int level = 0;
        Set<String> set = new HashSet<>(Arrays.asList(deadEnds));
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (set.contains(curr))
                    continue;
                if (curr.equals(target))
                    return level;
                set.add(curr);
                for (int[] ints : comb) {
                    int[] canPos = new int[]{curr.charAt(0) - '0', curr.charAt(1) - '0', curr.charAt(2) - '0', curr.charAt(3) - '0'};
                    for (int k = 0; k < 4; k++) {
                        canPos[k] += ints[k];
                        canPos[k] = canPos[k] > 9 ? 0 : canPos[k];
                        canPos[k] = canPos[k] < 0 ? 9 : canPos[k];
                    }
                    String cand = "" + canPos[0] + canPos[1] + canPos[2] + canPos[3];
                    if (!set.contains(cand))
                        queue.offer(cand);
                }
            }
            level++;
        }
        return -1;
    }



}
