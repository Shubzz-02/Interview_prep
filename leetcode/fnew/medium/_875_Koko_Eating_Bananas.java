package com.company.leetcode.fnew.medium;

public class _875_Koko_Eating_Bananas {

    public static void main(String[] args) {
        int[] piles = {1000000000};
        System.out.println(new _875_Koko_Eating_Bananas().minEatingSpeed(piles, 2));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }

        int l = 1, r = max;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int total = 0;
            for (int i = 0; i < piles.length; i++) {
                total += Math.ceil((double) piles[i] / mid);
            }

            if (total <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }

    public int minEatingSpeedTLE(int[] piles, int h) {
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        int mim = 1;
        for (int i = 1; i <= max; i++) {
            int total = 0;
            for (int j = 0; j < piles.length; j++) {

                total += Math.ceil((float) piles[j] / i);
            }
            if (total <= h) {
                mim = i;
                break;
            }
        }
        return mim;
    }

}
