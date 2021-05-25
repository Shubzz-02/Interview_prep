package com.company.leetcode.medium;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(new SolutionITR().intToRoman(3999));
    }
}

class SolutionITR {

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder builder = new StringBuilder();

        // greedy
        for (int i = 0; i < values.length && num > 0; i++) {
            while (values[i] <= num) {
                builder.append(strings[i]);
                num -= values[i];
            }
        }
        return builder.toString();
    }
}
