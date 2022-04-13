package com.company.leetcode.fnew.easy;

public class Longest_Common_Prefix_14 {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(new Longest_Common_Prefix_14().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r)
            return strs[l];
        else {
            int mid = (l + r) >>> 1;
            String lcpR = longestCommonPrefix(strs, l, mid);
            String lcpL = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpR, lcpL);
        }
    }

    private String commonPrefix(String lcpR, String lcpL) {
        int min = Math.min(lcpL.length(), lcpR.length());
        for (int i = 0; i < min; i++) {
            if (lcpL.charAt(i) != lcpR.charAt(i))
                return lcpL.substring(0, i);
        }
        return lcpL.substring(0, min);
    }
}
