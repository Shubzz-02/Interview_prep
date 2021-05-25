package com.company.leetcode.easy;


import java.util.Arrays;

public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(new SolutionCP().countPrimes(10));
    }
}

class SolutionCP {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, 0, n, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p])
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
        }
        int ct = 0;
        for (int i = 2; i <= n; i++)
            if (prime[i])
                ct++;
        return ct;
    }
}

