package com.company.leetcode.misc;

import java.util.Arrays;

public class ArrayEvenNumberOfDigits {
    public static void main(String[] args) {
        System.out.println(new SolutionAENOD().findNumbers(new int[]{555, 901, 482, 1771}));
    }
}

class SolutionAENOD {
    public int findNumbers(int[] nums) {
        return (int) Arrays.stream(nums).filter(i -> ((int) (Math.floor(Math.log10(i)) + 1) % 2) == 0).count();
//        for (int i : nums) {
//            int d = (int) (Math.floor(Math.log10(i))) + 1;
//            System.out.println(i + " " + d);
//        }
//        return 0;
    }
}
