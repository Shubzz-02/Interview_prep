package com.company.leetcode.fnew.easy;

import java.util.Arrays;

public class _1710_Maximum_Units_on_a_Truck {

    public static void main(String[] args) {

        int[][] boxes = {
                {5, 10},
                {2, 5},
                {4, 7},
                {3, 9}
        };
        System.out.println(new _1710_Maximum_Units_on_a_Truck().maximumUnits(boxes, 4));
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        System.out.println(Arrays.deepToString(boxTypes));

        int total = 0;
        for (int[] boxType : boxTypes) {
            int box = Math.min(truckSize, boxType[0]);
            total += box * boxType[1];
            truckSize -= box;
            if (truckSize == 0) {
                break;
            }
        }
        return total;
    }

}
