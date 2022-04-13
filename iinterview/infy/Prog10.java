package com.company.iinterview.infy;

public class Prog10 {
    public static void main(String[] args) {
        System.out.println(tripleXorSum(4, new int[]{1, 1,2, 3}));

    }

    public static int tripleXorSum(int N, int[] AR) {
        int a = 0;
        for (int i = 0; i < N - 3; i++) {
            a += fun(AR[i], fun(AR[i + 1], AR[i + 2]));
        }
        return (int) (a % Math.pow(10, 9) + 7);
    }

    public static int fun(int a, int b) {
        return (a + b) - 2 * (a & b);
    }
}
