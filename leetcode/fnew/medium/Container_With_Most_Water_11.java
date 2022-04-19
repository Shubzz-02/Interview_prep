package com.company.leetcode.fnew.medium;

public class Container_With_Most_Water_11 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Container_With_Most_Water_11().maxArea(arr));
    }

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            if (maxArea < area)
                maxArea = area;
            if (height[l] < height[r]) {
                l++;
            } else if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }
}
