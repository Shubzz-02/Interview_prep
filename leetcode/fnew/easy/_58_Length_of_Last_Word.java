package com.company.leetcode.fnew.easy;

public class _58_Length_of_Last_Word {

    public static void main(String[] args) {
        String s = "luffy is still joyboy";

        System.out.println(new _58_Length_of_Last_Word().lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int ct = 0;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            ct++;
        }
        return ct;
    }

}
