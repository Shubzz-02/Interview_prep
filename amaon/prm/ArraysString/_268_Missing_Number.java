package com.company.amaon.prm.ArraysString;

import java.util.Arrays;

public class _268_Missing_Number {

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(new _268_Missing_Number().missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        int len = nums.length;
        long sumN = ((long) len * (len + 1)) / 2;
        long sum = Arrays.stream(nums).sum();

        return (int) (sumN - sum);
    }

}
