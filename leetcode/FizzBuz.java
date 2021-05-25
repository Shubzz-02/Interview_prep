package com.company.leetcode;

public class FizzBuz {
    public static void main(String[] args) {
        print(100);
    }

    static void print(int n) {
        for (int i = 1; i < n; i++) {
            String o = "";
            if (i % 3 == 0)
                o += "Fizz";
            if (i % 5 == 0)
                o += "Buzz";
            if (o.equals(""))
                o = String.valueOf(i);
            System.out.println(o);
        }
    }
}
