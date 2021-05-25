package com.company.leetcode.easy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SolutionIOTA().intersection(new int[]{1,2,2,6,4,8,9,8,7,44,5},new int[]{2,2,6,7,8,9,6,5,44,5,4})));
    }
}

class SolutionIOTA {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> n1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> n2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        n1.retainAll(n2);
        return n1.stream().mapToInt(i -> i).toArray();
    }
}
