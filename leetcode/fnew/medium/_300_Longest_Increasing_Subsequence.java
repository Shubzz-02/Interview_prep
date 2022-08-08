package com.company.leetcode.fnew.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _300_Longest_Increasing_Subsequence {


    /*
    [10,9,2,5,3,7,101,18]
[0,1,0,3,2,3]
[7,7,7,7,7,7,7]
     */
    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 3, 2, 3};

        System.out.println(new _300_Longest_Increasing_Subsequence().lengthOfLIS(arr));

    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;

    }


    List<List<Integer>> ans = new ArrayList<>();

    public int lengthOfLTSRec(int[] nums) {

        func(0, nums, new ArrayList<>());

        int max = 1;

        for (List<Integer> list : ans) {
            System.out.println(list);
            int ct = 1;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) > list.get(i - 1)) {
                    ct++;
                }
            }

            if (ct == list.size()) {
                max = Math.max(max, ct);
            }
        }

        return max;
    }

    private void func(int i, int[] nums, List<Integer> es) {
        if (i >= nums.length) {
            ans.add(new ArrayList<>(es));
            return;
        }

        es.add(nums[i]);
        func(i + 1, nums, es);
        es.remove(es.size() - 1);
        func(i + 1, nums, es);
    }


}
