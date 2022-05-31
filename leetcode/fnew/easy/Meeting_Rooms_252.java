package com.company.leetcode.fnew.easy;

import java.util.Arrays;
import java.util.Comparator;

public class Meeting_Rooms_252 {

    public static void main(String[] args) {
        int[][] n = {
                {7, 10},
                {2, 4}
        };
        System.out.println(new Meeting_Rooms_252().canAttendMeetings(n));
    }

    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return true;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int min = intervals[0][0];
        int max = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= min && intervals[i][0] < max) {
                return false;
            }
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][1]);
        }
        return true;
    }

}
