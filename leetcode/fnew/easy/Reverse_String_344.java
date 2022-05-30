package com.company.leetcode.fnew.easy;

import java.util.Arrays;

public class Reverse_String_344 {

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        new Reverse_String_344().reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            s[l] = (char) (s[r] ^ s[l] ^ (s[r] = s[l]));
            l++;
            r--;
        }
    }
}
