package com.company.neetcode;

import com.company.leetcode.fnew.medium._853_Car_Fleet;

import java.util.Arrays;

public class Koko_Eating_Bananas {


    public static void main(String[] args) {

        int[] piles = {312884470};
        System.out.println(new Koko_Eating_Bananas().minEatingSpeed(piles, 312884469));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int min = Integer.MAX_VALUE;
        int l = 0, r = max;
        while (l <= r) {
            int mid = (l + r) >>> 1;

            int totalSum = 0;
            for (int pile : piles) {
                totalSum += Math.ceil(pile / (double) mid);
            }

            if (totalSum <= h) {
                min = Math.min(mid, min);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return min;
    }

}
