package com.company.leetcode.fnew.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _128_Longest_Consecutive_Sequence {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().trim().split(",")).mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new _128_Longest_Consecutive_Sequence().longestConsecutive(nums));

    }

    public int longestConsecutive(int... nums) {
        int longestConsecutive = 0;

        Set<Integer> set = new HashSet<>();
        for (int k : nums) {
            set.add(k);
        }

        for (int num : nums) {
            int count = 0;
            if (set.contains(num) && !set.contains(num - 1)) {
                count++;
                int j = num + 1;
                while (j <= (int) Math.pow(10, 9) && j >= (-1) * (int) Math.pow(10, 9)) {
                    if (set.contains(j)) {
                        j++;
                        count++;
                    } else {
                        break;
                    }
                }
            }
            longestConsecutive = Math.max(count, longestConsecutive);
        }
        return longestConsecutive;
    }

    public int longestConsecutive_ONLOGN(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longCons = 1;
        int currCons = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currCons += 1;
                } else {
                    longCons = Math.max(longCons, currCons);
                    currCons = 1;
                }
            }
        }
        return Math.max(longCons, currCons);
    }

}
