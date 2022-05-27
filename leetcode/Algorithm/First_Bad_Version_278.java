package com.company.leetcode.Algorithm;

public class First_Bad_Version_278 {

    public static void main(String[] args) {

    }

    public int firstBadVersion(int n) {
            int low = 0;
            int high = n;
            while (low <= high) {
                int mid = (low + high) >>> 1;

                if (isBadVersion(mid)) {
                    high = mid;
                } else {
                    low = mid - 1;
                }
            }
            return low;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }

}
