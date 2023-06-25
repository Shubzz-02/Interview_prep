package com.company.neetcode;

import java.util.Arrays;
import java.util.Stack;

public class Daily_Temperatures {

    public static void main(String[] args) {

        int[] temperatures = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};

        System.out.println(Arrays.toString(new Daily_Temperatures().dailyTemperatures(temperatures)));
    }

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = stack.peek() - i;
            }

            stack.push(i);
        }
        return ans;
    }
}
