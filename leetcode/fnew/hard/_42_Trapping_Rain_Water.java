package com.company.leetcode.fnew.hard;

import java.util.Stack;

public class _42_Trapping_Rain_Water {

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(new _42_Trapping_Rain_Water().trap(height));

    }

    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            if (!stack.isEmpty() && height[i] <= stack.peek()) {
                leftMax[i] = stack.peek();
                continue;
            }
            if (stack.isEmpty()) {
                leftMax[i] = 0;
            } else {
                leftMax[i] = stack.peek();
            }

            stack.push(height[i]);
        }

        stack.removeAllElements();

        for (int i = height.length - 1; i >= 0; i--) {
            if (!stack.isEmpty() && height[i] <= stack.peek()) {
                rightMax[i] = stack.peek();
                continue;
            }
            if (stack.isEmpty()) {
                rightMax[i] = 0;
            } else {
                rightMax[i] = stack.peek();
            }

            stack.push(height[i]);
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int currArea = Math.min(leftMax[i], rightMax[i]) - height[i];
            maxArea += (Math.max(currArea, 0));
        }

        return maxArea;
    }

}
