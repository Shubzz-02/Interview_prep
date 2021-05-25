package com.company.leetcode.easy;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        System.out.println(new SolutionFUCIAS().firstUniqChar("cc"));
    }
}


class SolutionFUCIAS {
    public int firstUniqChar(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            s = s.substring(0, i) +"_"+ s.substring(i + 1);
            if (s.indexOf(ch) < 0)
                return i;
            s = s.substring(0, i) + ch + s.substring(i + 1);
        }
        return -1;
    }
}
