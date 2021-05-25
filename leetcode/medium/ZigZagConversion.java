package com.company.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(new SolutionZZC().convert("PAYPALISHIRING", 4));
    }
}


class SolutionZZC {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int len = s.length();
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, len); i++)
            list.add(new StringBuilder());
        int cr = 0;
        boolean gd = false;
        for (char c : s.toCharArray()) {
            list.get(cr).append(c);
            if (cr == 0 || cr == numRows - 1) {
                gd = !gd;
            }
            cr += (gd) ? 1 : -1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder list1 : list)
            stringBuilder.append(list1);
        return stringBuilder.toString();
    }
}
