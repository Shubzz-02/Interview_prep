package com.company.leetcode.march;

public class RemovePalindromic {
}

class SolutionRP {
    public int removePalindromeSub(String s) {
        if (s.isEmpty())
            return 0;
        if (isPalindrome(s))
            return 1;
        return 2;
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int l = s.length() - 1;
        while (i < l) {
            if (s.charAt(i++) != s.charAt(l--))
                return false;
        }
        return true;
    }
}
