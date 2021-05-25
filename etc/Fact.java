package com.company.etc;

public class Fact {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            int n = i;
            System.out.println("----------"+i+"---------");
            System.out.println(fact(n));
            System.out.println(Math.ceil(Math.sqrt(2 * Math.PI * n) * Math.pow((n / Math.E), n)));
            System.out.println("----------"+i+"---------\n");
        }
    }

    static int fact(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }
}
