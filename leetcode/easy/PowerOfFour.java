package com.company.leetcode.easy;

public class PowerOfFour {
    public static void main(String[] args) {
        for(int i=0;i<200;i++)
            System.out.println(i+ " = "+new SolutionPOF().isPowerOfFour(i));
    }
}

class SolutionPOF {
    public boolean isPowerOfFour(int n) {
        //return (Integer.toString(n, 4).matches("^10*$"));
//        return (Math.log10(n) / Math.log10(4)) % 1 == 0;
        System.out.print(" " + Integer.toString(n, 4)+ " ");
        return (Integer.toString(n, 4).matches("^[0-9]0*$"));
    }
}

/*
0 1 2 3
10 11 12 13
20 21 22 23
30 31 32 33
100 101 102 103
110
*/
