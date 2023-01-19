package com.company.leetcode.fnew.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3Sum {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new _15_3Sum().threeSum(nums));


    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (r < nums.length - 1 && nums[r] == nums[r + 1]) {
                    r--;
                    continue;
                }
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    list.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return list;
    }

}
