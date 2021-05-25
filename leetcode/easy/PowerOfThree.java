package com.company.leetcode.easy;

public class PowerOfThree {
    public static void main(String[] args) {
        System.out.println(new SolutionPOT().isPowerOfThree(15));
    }
}

class SolutionPOT {
    public boolean isPowerOfThree(int n) {
        //System.out.println(Integer.toString(n, 3));
        return Integer.toString(n, 3).matches("^10*$");
        //return false;
        //return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
