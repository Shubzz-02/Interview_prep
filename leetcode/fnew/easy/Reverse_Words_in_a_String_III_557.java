package com.company.leetcode.fnew.easy;

public class Reverse_Words_in_a_String_III_557 {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(new Reverse_Words_in_a_String_III_557().reverseWords(s));

    }

    public String reverseWords(String s) {
        s = s+" ";
        int j = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                ans.append(reverseString(s.substring(j, i).toCharArray()));
                ans.append(" ");
                j=i+1;
            }
        }
        return ans.toString().trim();
    }

    public String reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            s[l] = (char) (s[r] ^ s[l] ^ (s[r] = s[l]));
            l++;
            r--;
        }
        return new String(s);
    }
}
