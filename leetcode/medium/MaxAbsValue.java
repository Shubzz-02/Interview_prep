package com.company.leetcode.medium;

public class MaxAbsValue {
    public static void main(String[] args) {
        System.out.println(new SolutionMAV().maxAbsValExpr(new int[]{1, 2, 3, 4}, new int[]{-1, 4, 5, 6}));
    }
}

class SolutionMAV {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int max = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i; j < arr2.length; j++) {
                int c = Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j]) + Math.abs(i - j);
                max = Math.max(c, max);
            }
        }
        return max;
    }
}
