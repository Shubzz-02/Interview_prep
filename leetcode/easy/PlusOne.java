package com.company.leetcode.easy;

import java.math.BigInteger;
import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        arr = new SolutionPO().plusOne(arr);
        System.out.println(Arrays.toString(arr));
    }
}


class SolutionPO {
    public int[] plusOne(int[] digits) {
        String arr = Arrays.toString(digits).trim().replace(",", "").replace("[", "").replace("]", "").replace(" ", "");

        int a = 0;
        StringBuilder l0 = new StringBuilder();
        while (a < arr.length() && arr.charAt(a) == '0') {
            l0.append("0");
            a++;
        }
        BigInteger big = new BigInteger(arr);
        big = big.add(new BigInteger("1"));

        if (l0.length() > 0) {
            l0 = new StringBuilder(l0.substring(1));
        }
        String s = l0.toString() + big;

        int len = s.length();
        int[] arrr = new int[len];
        for (int i = 0; i < len; i++) {
            arrr[i] = Character.getNumericValue(s.charAt(i));
        }
        //System.out.println(Arrays.toString(arrr));
        return arrr;
    }
}
