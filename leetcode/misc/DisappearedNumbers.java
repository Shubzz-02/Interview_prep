package com.company.leetcode.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisappearedNumbers {
    public static void main(String[] args) {
        System.out.println(new SolutionDN().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}

class SolutionDN {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] > 0)
                nums[Math.abs(num) - 1] = nums[Math.abs(num) - 1] * -1;
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                list.add(i + 1);
        }
        return list;
    }
}
