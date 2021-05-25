package com.company.leetcode.medium;

public class PowXN {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new SolutionPXN().myPow(-1.00000 ,-2147483648));
        long end = System.currentTimeMillis();
        System.out.println("Time Taken " + (end - start) + "ms");
    }
}

class SolutionPXN {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n < 0) {
            if (x < 0)
                x = -x;
            if (n == Integer.MIN_VALUE)
                return 1 / myPow(x, Integer.MAX_VALUE);
            return 1 / myPow(x, -n);
        }
        double res = myPow(x, n / 2);
        if (n % 2 == 0)
            return res * res;
        else
            return res * res * x;
    }
}
