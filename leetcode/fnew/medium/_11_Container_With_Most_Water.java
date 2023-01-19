package com.company.leetcode.fnew.medium;

public class _11_Container_With_Most_Water {

    public static void main(String[] args) {

        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new _11_Container_With_Most_Water().maxArea(nums));
    }


    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;

        int max = 0;
        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
