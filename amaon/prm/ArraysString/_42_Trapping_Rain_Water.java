package com.company.amaon.prm.ArraysString;

public class _42_Trapping_Rain_Water {

    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new _42_Trapping_Rain_Water().trap(heights));
    }

    public int trap(int[] height) {
        int totalWater = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax[i] = max;
            max = Math.max(max, height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            int cs = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (cs > 0) {
                totalWater += cs;
            }
        }
        return totalWater;
    }

}
