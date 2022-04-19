package com.company.leetcode.fnew.medium;

import com.company.etc.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public static void main(String[] args) {
        int[] num = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new ThreeSum_15().threeSum(num);
        for (List<Integer> l : res) {
            System.out.println(l);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (r < nums.length - 1 && nums[r] == nums[r + 1]) {
                    r--;
                    continue;
                }
                if (nums[i] + nums[l] + nums[r] > 0)
                    r--;
                else if (nums[i] + nums[l] + nums[r] < 0)
                    l++;
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add((nums[r]));
                    res.add(list);
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}
