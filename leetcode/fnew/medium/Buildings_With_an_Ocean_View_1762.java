package com.company.leetcode.fnew.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Buildings_With_an_Ocean_View_1762 {

    public static void main(String[] args) {
        int[] height = {4, 2, 3, 1};
        int[] ans = new Buildings_With_an_Ocean_View_1762().findBuildings(height);

        System.out.println(Arrays.toString(ans));
    }

    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int maxHeight = heights[heights.length - 1];
        list.add(heights.length - 1);
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                list.add(i);
                maxHeight = Math.max(heights[i], maxHeight);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = list.size()-1; i >=0; i--) {
            ans[(list.size()-1)-i] = list.get(i);
        }
        return ans;
    }

}
