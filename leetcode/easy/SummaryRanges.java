package com.company.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(new SolutionSR().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }
}

class SolutionSR {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1] + 1) j = i;
            if (i == nums.length - 1 || nums[i] != nums[i + 1] - 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[j]);
                if (j != i) sb.append("->").append(nums[i]);
                res.add(sb.toString());
            }
        }
        return res;
    }
}
