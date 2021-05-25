package com.company.etc;

public class SinGleDigitBitManipulation {
    public static void main(String[] args) {
        System.out.println(xor(new int[]{1, 1,1,1,1,1,1,1,1,1}));
    }

    private static int xor(int[] arr) {
//        int n = 10_1001;
//        System.out.println(Math.pow(10, 5));
//        System.out.println(Integer.MAX_VALUE);
        //System.out.println(n);
        int xor = 0;
        for (int i : arr)
            xor ^= i;
        return xor;
    }
}
