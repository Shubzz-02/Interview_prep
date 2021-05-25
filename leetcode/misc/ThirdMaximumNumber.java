package com.company.leetcode.misc;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        System.out.println(
                new SolutionTMN().thirdMax(new int[]{2,2,3,1}));
    }
}

class SolutionTMN {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(TreeSet::new)); //Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int s = set.size();
        if (s <= 2)
            return set.last();
        else {
            set.pollLast();
            set.pollLast();
            return set.pollLast();
        }
    }
}
