package com.company.topic.monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class PreviousSmaller {

    public static void main(String[] args) {
        int[] arr = {1, 3, 10, 7, 5, 24, 4};
        System.out.println(Arrays.toString(new PreviousSmaller().previousSmaller(arr)));
    }

    int[] previousSmaller(int... nums) {

        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(nums[i]);
        }
        return ans;
    }

}
