package com.company.leetcode.fnew.medium;

public class _1143_Longest_Common_Subsequence {

    public static void main(String[] args) {
        String text1 = "bl";
        String text2 = "yby";
        System.out.println(new _1143_Longest_Common_Subsequence().longestCommonSubsequence(text1,text2));


    }


    public int longestCommonSubsequence(String text1, String text2) {
        int total =0;

        int len1 = text1.length();
        int len2 = text2.length();
        
        int i=0,j=0;
        while (i < len1 && j < len2){
            if(text2.charAt(j) != text1.charAt(i)){
                i++;
            }else if(text2.charAt(j) == text1.charAt(i)){
                total++;
                i++;
                j++;
            }else {
                i++;
            }
        }
        return total;
    }

}
