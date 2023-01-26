package com.company.leetcode.fnew.hard;

import java.util.Stack;

public class _84_Largest_Rectangle_in_Histogram {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new _84_Largest_Rectangle_in_Histogram().largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {

        Stack<int[]> stack = new Stack<>();

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int lastIndex = i;
            while (!stack.isEmpty() && heights[i] < stack.peek()[1]) {
                int[] arr = stack.pop();
                lastIndex = arr[0];
                maxArea = Math.max((i - arr[0]) * arr[1], maxArea);
            }

            stack.push(new int[]{lastIndex, heights[i]});
        }

        while (!stack.isEmpty()) {
            int[] arr = stack.pop();
            maxArea = Math.max((heights.length - arr[0]) * arr[1], maxArea);
        }

        return maxArea;
    }

}
