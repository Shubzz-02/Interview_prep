package com.company.etc;

public class ZeroInNFact {
    public static void main(String[] args) {
//        int n = 10;
//        System.out.println("Number of 0 in " + n + "! " + countZero(n));
        int x = 0;
        for (x = 0; x <= 5; x++) {
            System.out.println(x);
        }
    }

    private static int countZero(int n) {
        int ct = 0;

        for (int i = 5; n / i >= 1; i *= 5) {
            ct += n / i;
        }

        return ct;
    }
}
