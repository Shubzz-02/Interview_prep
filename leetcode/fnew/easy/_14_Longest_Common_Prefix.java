package com.company.leetcode.fnew.easy;

public class _14_Longest_Common_Prefix {


    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};

        System.out.println(new _14_Longest_Common_Prefix().longestCommonPrefix(strs));
    }


    public String longestCommonPrefix(String[] strs) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            for (String s : strs) {
                if (i == s.length() || s.charAt(i) != strs[0].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }

}
