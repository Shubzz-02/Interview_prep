package com.company.leetcode.fnew.easy;

import java.util.Locale;

public class _125_Valid_Palindrome {

    public static void main(String[] args) {
        String a = "1A man, a plan, a canal: Panama1";

        System.out.println(new _125_Valid_Palindrome().isPalindrome(a));
    }

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "");
        s = s.toLowerCase(Locale.ROOT);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt((s.length() - 1) - i)) {
                return false;
            }
        }
        return true;
    }

}
