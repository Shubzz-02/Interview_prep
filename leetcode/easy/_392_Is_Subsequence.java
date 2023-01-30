package com.company.leetcode.easy;

public class _392_Is_Subsequence {

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahgdc";

        System.out.println(new _392_Is_Subsequence().isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        int i = 0, j = 0;
        int ct = 0;
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                ct++;
                i++;
            }
            j++;
        }
        return (ct == s.length());

    }

}
