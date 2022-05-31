package com.company.leetcode.fnew.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Meeting_Rooms_II_253   {

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {0, 30},
                {5, 10},
                {15, 20}
        };
        System.out.println(new Meeting_Rooms_II_253().minMeetingRooms(a));
    }

    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                intervals.length,
                Comparator.comparingInt(o -> o)
        );

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        priorityQueue.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= priorityQueue.peek()) {
                priorityQueue.poll();
            }
            priorityQueue.add(intervals[i][1]);
        }
        return priorityQueue.size();
    }
}
