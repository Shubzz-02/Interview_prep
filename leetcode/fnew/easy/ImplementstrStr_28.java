package com.company.leetcode.fnew.easy;

public class ImplementstrStr_28 {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        System.out.println(new ImplementstrStr_28().strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

}
