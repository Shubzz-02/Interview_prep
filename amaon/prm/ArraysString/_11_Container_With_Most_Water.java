package com.company.amaon.prm.ArraysString;

public class _11_Container_With_Most_Water {

    public static void main(String[] args) {

        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new _11_Container_With_Most_Water().maxArea(arr));
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if (height[i] <= height[j]) {
                i++;
            } else if (height[i] > height[j]) {
                j--;
            }
        }
        return max;
    }

}
