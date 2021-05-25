package com.company.etc;

public class MaxSumArray {
    public static int kadane(int[] a) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int j : a) {
            max_ending_here = max_ending_here + j;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("The sum of contiguous sub-array with the " +
                "largest sum is " + kadane(A));
    }
}
