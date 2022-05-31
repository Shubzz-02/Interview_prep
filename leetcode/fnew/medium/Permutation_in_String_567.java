package com.company.leetcode.fnew.medium;

public class Permutation_in_String_567 {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(new Permutation_in_String_567().checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Array = new int[26];
        int[] s2Array;

        int s1Len = s1.length();

        int i = 0, j = s1Len - 1;
        for (int k = 0; k < s1.length(); k++) {
            int index = (int) s1.charAt(k) - 97;
            s1Array[index] = s1Array[index]+1;
        }

        while (j < s1Len) {
            s2Array = new int[26];
            while (i <= j) {
                int index = (int) s2.charAt(i) - 97;
                s2Array[index] = s2Array[index]+1;
                i++;
            }
            int total=0;
            for (int k = 0; k < 26; k++) {
                if (s1Array[k] == s2Array[k] && s1Array[k] != 0) {
                    total++;
                }
            }
            if(total == s1Len)
                return true;
            j++;
            i = j - s1Len;
        }
        return false;
    }

}
