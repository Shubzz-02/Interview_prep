package com.company.leetcode.fnew.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MONOTONIC_Buildings_With_an_Ocean_View_1762 {

    public static void main(String[] args) {
        int[] height = {4, 2, 3, 1};
        int[] ans = new MONOTONIC_Buildings_With_an_Ocean_View_1762().findBuildings(height);

        System.out.println(Arrays.toString(ans));
    }

    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> list = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                list.add(i);
            }
            stack.push(heights[i]);
        }
        int[] ans = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            ans[(list.size() - 1) - i] = list.get(i);
        }
        return ans;
    }

}
