package com.company.neetcode;

public class Container_With_Most_Water {

    public static void main(String[] args) {
        System.out.println(new Container_With_Most_Water().maxArea(new int[]{1, 8, 6, 2, 100, 400, 8, 3, 7}));
    }

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;

        int maxAres = 0;
        while (l < r) {
            maxAres = Math.max(maxAres, (r - l) * Math.min(height[l], height[r]));

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxAres;
    }
}
