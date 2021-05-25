package com.company.leetcode.misc;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SolutionSOASA().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}

class SolutionSOASA {
    public int[] sortedSquares(int[] nums) {
        return Arrays.stream(nums).map(i -> (int) Math.pow(i, 2)).sorted().toArray();
    }
}
