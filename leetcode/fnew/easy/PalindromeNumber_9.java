package com.company.leetcode.fnew.easy;

public class PalindromeNumber_9 {
    public static void main(String[] args) {
        int x = 101;
        System.out.println(new PalindromeNumber_9().isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber/10;
    }
}
