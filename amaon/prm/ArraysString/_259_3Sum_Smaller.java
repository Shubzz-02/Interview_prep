package com.company.amaon.prm.ArraysString;

import java.util.Arrays;

public class _259_3Sum_Smaller {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        int target = 2;
        System.out.println(new _259_3Sum_Smaller().threeSumSmaller(nums, target));
    }

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int smaller = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < target) {
                    smaller += r - l;
                    l++;
                } else {
                    r--;
                }
            }
        }
        return smaller;

    }

}
