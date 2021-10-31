package com.company.etc;

import java.math.BigInteger;

public class TOATOI {
    public static void main(String[] args) {
        String s = "42";
        System.out.println(new SolutionTOI().myAtoi(s));
    }
}


class SolutionTOI {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0)
            return 0;
        char sig = s.charAt(0);
        if (!(sig >= '0' && sig <= '9') && sig != '+' && sig != '-')
            return 0;
        if (sig == '-') {
            sig = '-';
        } else
            sig = '+';
        if (s.charAt(0) == '-' || s.charAt(0) == '+')
            s = s.substring(1);
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i));
            } else {
                break;
            }
        }
        if (sb.length() == 0)
            return 0;
        BigInteger bi = new BigInteger(sb.toString());
//
//        long c = Long.parseLong(sb.toString());
        if (sig == '-')
            bi = bi.multiply(BigInteger.valueOf(-1));
        if (bi.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            return Integer.MAX_VALUE;
        } else if (bi.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
            return Integer.MIN_VALUE;
        } else {
            return bi.intValue();
        }
//        if (c > (long) Integer.MAX_VALUE)
//            return Integer.MAX_VALUE;
//        else if (c < (long) Integer.MIN_VALUE)
//            return Integer.MIN_VALUE;
//        else {
//            return (int) c;
//        }
    }
}