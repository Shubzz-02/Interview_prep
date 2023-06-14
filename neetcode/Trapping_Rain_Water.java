package com.company.neetcode;

import java.util.Stack;

public class Trapping_Rain_Water {


    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(new Trapping_Rain_Water().trap(height));
    }

    public int trap(int[] height) {


        int[] left = new int[height.length];
        int[] right = new int[height.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {

            if (!stack.isEmpty() && height[i] <= stack.peek()) {
                left[i] = stack.peek();
                continue;
            }

            if (stack.isEmpty()) {
                left[i] = 0;
            } else {
                left[i] = stack.peek();
            }
            stack.push(height[i]);
        }


        stack.removeAllElements();

        for (int i = height.length - 1; i >= 0; i--) {

            if (!stack.isEmpty() && height[i] <= stack.peek()) {
                right[i] = stack.peek();
                continue;
            }

            if (stack.isEmpty()) {
                right[i] = 0;
            } else {
                right[i] = stack.peek();
            }

            stack.push(height[i]);
        }

        int maxUnit = 0;

        for (int i = 0; i < height.length; i++) {
            int currUnit = Math.min(left[i], right[i]) - height[i];
            maxUnit += Math.max(currUnit, 0);
        }

        return maxUnit;
    }
}
