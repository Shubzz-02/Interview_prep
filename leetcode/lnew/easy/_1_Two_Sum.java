package com.company.leetcode.lnew.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1_Two_Sum {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(new _1_Two_Sum().twoSum(arr, 9)));

    }

//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            int sub = target - nums[i];
//
//            if (map.containsKey(sub) && map.get(sub) != i) {
//                return new int[]{i, map.get(sub)};
//            }
//        }
//        return null;
//    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cmp = target - nums[i];
            if (map.containsKey(cmp)) {
                return new int[]{i, map.get(cmp)};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

}
