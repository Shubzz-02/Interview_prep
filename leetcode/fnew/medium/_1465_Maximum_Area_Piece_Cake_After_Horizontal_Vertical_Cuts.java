package com.company.leetcode.fnew.medium;

import java.util.Arrays;

public class _1465_Maximum_Area_Piece_Cake_After_Horizontal_Vertical_Cuts {

    public static void main(String[] args) {

        int[] hor = {1, 2, 4};
        int[] ver = {1, 3};

        System.out.println(
                new _1465_Maximum_Area_Piece_Cake_After_Horizontal_Vertical_Cuts().maxArea(5, 4,
                        hor, ver));
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int n = horizontalCuts.length;
        int m = verticalCuts.length;

        int maxHorizontalCut = Math.max(horizontalCuts[0], h - horizontalCuts[n - 1]);
        int maxVerticalCut = Math.max(verticalCuts[0], w - verticalCuts[m - 1]);

        for (int i = 1; i < n; i++) {
            maxHorizontalCut = Math.max(maxHorizontalCut,
                    horizontalCuts[i] - horizontalCuts[i - 1]);
        }

        for (int i = 1; i < m; i++) {
            maxVerticalCut = Math.max(maxVerticalCut,
                    verticalCuts[i] - verticalCuts[i - 1]);
        }

        return (int)(((long) maxHorizontalCut * maxVerticalCut) % 1000000007);

    }

}
