package com.company.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] arr = new SolutionII().insert(new int[][]{
                {1, 5},
                {6, 8}
        }, new int[]{5, 6});
        for (int[] a : arr)
            System.out.println(Arrays.toString(a));
    }
}

class SolutionII {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0])
            list.add(intervals[i++]);
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);
        while (i < n) list.add(intervals[i++]);
        return list.toArray(new int[list.size()][2]);

    }
}
//
//class SolutionII {
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        List<int[]> list = new ArrayList<>();
//        int i = 0;
//        while (i < intervals.length) {
//            if (check(newInterval[0], newInterval[1], intervals[i][0], intervals[i][1])) {
//                intervals[i][0] = Math.min(intervals[i][0], newInterval[0]);
//                intervals[i][1] = Math.max(intervals[i][1], newInterval[1]);
//                int j = i + 1;
//                if (j >= intervals.length)
//                    list.add(intervals[i]);
//                else
//                    while (j < intervals.length) {
//                        if (intervals[j][0] >= intervals[i][0] && intervals[j][0] <= intervals[i][1]) {
//                            intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
//                        } else {
//                            list.add(intervals[i]);
//                            i = j - 1;
//                            break;
//                        }
//                        j++;
//                    }
//            } else {
//                list.add(intervals[i]);
//            }
//            i++;
//        }
//        int[][] arr = list.toArray(new int[list.size()][2]);
//        Arrays.sort(arr, Arrays::compare);
//        return arr;
//    }
//
//    private boolean check(int a, int b, int c, int d) {
//        return (a >= c && a <= d || c >= a && c <= b);
//    }
//}
