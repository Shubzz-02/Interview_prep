package com.company.leetcode.misc;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {
        System.out.println(new SolutionHC().heightChecker(new int[]{1,1,4,2,1,3}));
    }
}

class SolutionHC {
    public int heightChecker(int[] heights) {
        int[] temp = new int[heights.length];
        System.arraycopy(heights, 0, temp, 0, heights.length);
        Arrays.sort(heights);
        int ct = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != temp[i])
                ct++;
        }
        return ct;
    }
}
