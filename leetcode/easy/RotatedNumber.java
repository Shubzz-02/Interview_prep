package com.company.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RotatedNumber {
    public static void main(String[] args) {
        System.out.println(new SolutionRN().rotatedDigits(857));
        //System.out.println(new SolutionRN().isGoodNumber(259));
    }
}


class SolutionRN {

    Map<Integer, Integer> map;


    public int rotatedDigits(int n) {
        map = new HashMap<>();
        map.put(2, 5);
        map.put(6, 9);
        map.put(9, 6);
        map.put(5, 2);
        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8);
        int ct = 0;
        for (int i = 1; i <= n; i++) {
            if (isGoodNumber(i)) {
                ct++;
            }
        }
        return ct;
    }
//

    boolean isGoodNumber(int i) {
        int new_numb = 0, b = 1, temp = i;
        while (temp > 0) {
            int n = temp % 10;
            switch (n) {
                case 2:
                case 5:
                case 6:
                case 9:
                case 0:
                case 1:
                case 8:
                    new_numb += map.get(n) * b;
                    b *= 10;
                    break;
                default:
                    return false;
            }
            temp /= 10;
        }
        return new_numb != i;
    }
}
