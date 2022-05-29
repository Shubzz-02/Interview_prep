package com.company.leetcode.fnew.medium;

import java.util.HashMap;
import java.util.Map;

public class Subarray_Sum_Equals_K_560 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(new Subarray_Sum_Equals_K_560().subarraySum(nums, 2));
    }

    public int subarraySum(int[] nums, int k) {
        int total = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
             prefixSum += num;
            int rem = Math.abs(k - prefixSum);
            if (map.containsKey(rem)) {
                total += map.get(rem);
            } else {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
        }
        return total;
    }

}
