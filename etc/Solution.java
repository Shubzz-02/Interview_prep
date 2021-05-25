package com.company.etc;

public class Solution {
    public static String countAndSay(int n) {
        if (n == 1) return "1";
        if (n == 2) return "11";


        String ans = "11";
        for (int i = 3; i <= n; i++) {
            int len = ans.length();
            int ct = 1;
            String temp = "";
            for (int j = 0; j < len; j++) {
                if (j < len - 1 && ans.charAt(j) == ans.charAt(j + 1)) {
                    ct++;
                } else {
                    if (j == (len - 2) && ans.charAt(j) != ans.charAt(j + 1) && ct == 1) {
                        temp += String.valueOf(1) + String.valueOf(ans.charAt(j));
                    } else {
                        temp += String.valueOf(ct) + String.valueOf(ans.charAt(j));
                        ct = 1;
                    }
                }
            }
            ans = temp;
        }
        return ans;
    }


    public static void main(String[] args) {
//        for (int i = 1; i <= 20; i++) {
        System.out.println(Solution.countAndSay(6));
//        }

    }
}
