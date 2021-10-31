package com.company.leetcode.hard;

public class BasicCalculator {

    public static void main(String[] args) {
        SolutionBC basicCalculator = new SolutionBC();
        System.out.println(basicCalculator.calculate("2*3-4*5"));
    }


}

class SolutionBC {
    public int calculate(String s) {
        int result = 0;
        int sign = 1;
        int num = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (c == '+') {
                sign = 1;
                i++;
                continue;
            }
            if (c == '-') {
                sign = -1;
                i++;
                continue;
            }
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
                i++;
                continue;
            }
            if (c == ')') {
                result += sign * num;
                sign = 1;
                num = 0;
                i++;
                continue;
            }
            if (c == '(') {
                result += sign * num;
                sign = 1;
                num = 0;
                i++;
                int subResult = calculate(s.substring(i));
                result += sign * subResult;
                i += subResult;
                continue;
            }
        }
        return result;
    }
}