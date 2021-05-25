package com.company.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {0, 2}, {2, 3}, {4, 6}, {4, 5}, {5, 5}, {0, 2}, {3, 3}};
        intervals = new SolutionMI().merge(intervals);
        for (int[] a : intervals)
            System.out.print("\n" + Arrays.toString(a) + " ");
    }
}


class SolutionMI {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Arrays::compare);
        List<List<Integer>> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int j = i + 1;
            int m = intervals[i][1];
            while (j < intervals.length) {
                if (intervals[j][0] >= intervals[i][0] && intervals[j][0] <= m) {
                    m = Math.max(m, intervals[j][1]);
                    j++;
                } else {
                    break;
                }
            }
            List<Integer> lis = new ArrayList<>();
            lis.add(intervals[i][0]);
            lis.add(m);
            list.add(lis);
            i = j;
        }
        return list.stream().map(o -> o.stream().mapToInt(u -> u).toArray()).toArray(int[][]::new);
    }
}
