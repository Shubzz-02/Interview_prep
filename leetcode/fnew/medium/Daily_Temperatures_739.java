package com.company.leetcode.fnew.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Daily_Temperatures_739 {

    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = new Daily_Temperatures_739().dailyTemperatures(arr);
        System.out.println(Arrays.toString(ans));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int currDate = 0; currDate < temperatures.length; currDate++) {
            int currDateTemp = temperatures[currDate];
            while (!deque.isEmpty() && temperatures[deque.peek()] < currDateTemp) {
                int prevDay = deque.pop();

                ans[prevDay] = currDate - prevDay;
            }
            deque.push(currDate);
        }
        return ans;
    }
}
