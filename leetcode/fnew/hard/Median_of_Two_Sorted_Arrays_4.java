package com.company.leetcode.fnew.hard;

public class Median_of_Two_Sorted_Arrays_4 {

    public static void main(String[] args) {
        int[] num1 = {1, 3};
        int[] num2 = {2};
        System.out.println(new Median_of_Two_Sorted_Arrays_4().findMedianSortedArrays(num1, num2));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1Length = nums1.length;
        int n2Length = nums2.length;

        int[] mid = new int[2];
        int mi = (n1Length + n2Length) / 2;

        int i = 0;
        int j = 0;
        int k = 0;
        while (k < n1Length + n2Length) {
            int min = 0;
            if (i < n1Length && j < n2Length) {
                if (nums1[i] <= nums2[j]) {
                    min = nums1[i];
                    i++;
                } else {
                    min = nums2[j];
                    j++;
                }
            } else if (i >= n1Length) {
                min = nums2[j];
                j++;
            } else if (j >= n2Length) {
                min = nums1[i];
                i++;
            }
            if (mi == k+1) {
                mid[0] = min;
            } else if (mi == k) {
                mid[1] = min;
                break;
            }
            k++;
        }
        if ((n1Length + n2Length) % 2 == 0) {
            return (mid[0] + mid[1]) / 2D;
        } else {
            return (mid[0]);
        }
    }

}
