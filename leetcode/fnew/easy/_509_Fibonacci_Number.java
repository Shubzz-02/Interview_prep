package com.company.leetcode.fnew.easy;

public class _509_Fibonacci_Number {

    public static void main(String[] args) {

        System.out.println(new _509_Fibonacci_Number().fib(4));
    }

    public int fib(int n) {
        if (n < 1) {
            return 0;
        }
//        int[] arr = new int[n+1];

        int f = 0;
        int s = 1;
        for (int i = 2; i <= n; i++) {
            int t = f + s;
            f = s;
            s = t;
//            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return s;
    }
}
