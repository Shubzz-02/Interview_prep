package com.company.leetcode.easy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SolutionIOTAII().intersect(new int[]{1,2,2,6,4,8,9,8,7,44,5},new int[]{2,2,6,7,8,9,6,5,44,5,4})));
    }
}

class SolutionIOTAII {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 || len2 == 0)
            return new int[0];

        int i = 0, j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();

        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else
                j++;
        }
        return result.stream().mapToInt(o -> o).toArray();
    }
}
