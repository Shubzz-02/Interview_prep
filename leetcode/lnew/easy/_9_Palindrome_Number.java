package com.company.leetcode.lnew.easy;

public class _9_Palindrome_Number {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        int revNo = 0;
        while (x > revNo) {
            revNo = revNo * 10 + x % 10;
            x /= 10;
        }
        return x == revNo || x == revNo / 10;
    }
}
