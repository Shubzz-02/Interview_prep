package com.company.amaon.prm.ArraysString;

public class _8_ATOI {

    public static void main(String[] args) {
        String a = "-2147483647";
        System.out.println(new _8_ATOI().myAtoi(a));
    }

    public int myAtoi(String s) {
        s = s.trim();
        int index = 0;
        int sign = 1;
        int res = 0;
        if(s.length() == 0)
            return 0;
        if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int num = s.charAt(index) - '0';

            if ((res > Integer.MAX_VALUE / 10) || ((res == Integer.MAX_VALUE / 10) && (num > 7))) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            index++;
            res = res * 10 + num;
        }
        return res * sign;
    }

}
