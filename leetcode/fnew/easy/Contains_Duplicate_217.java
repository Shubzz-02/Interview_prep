package com.company.leetcode.fnew.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Contains_Duplicate_217 {

    public static void main(String[] args) {
        int[] num = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(new Contains_Duplicate_217().containsDuplicate(num));

    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return set.size() != nums.length;
    }
}