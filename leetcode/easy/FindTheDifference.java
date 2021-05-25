package com.company.leetcode.easy;

public class FindTheDifference {
    public static void main(String[] args) {
        System.out.println(new SolutionFTD().findTheDifference("abcd", "abcde"));
        //System.out.println(s.chars());
    }
}

class SolutionFTD {
    public char findTheDifference(String s, String t) {
//        Set<Character> ss = s.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
//        Set<Character> st = t.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
//        st.removeAll(ss);
//        if (st.isEmpty())
//            return '\u0000';
//        return st.iterator().next();
//        char[] arr = (s + t).toCharArray();
//        int xor = 0;
//        for (char ch : arr) {
//            xor ^= ch;
//        }
//        return (char) xor;
        s += t;
        int len = s.length();
        int xor = 0;
        for(int i=0;i<len;i++){
            xor ^= s.charAt(i);
        }
        return (char)xor;
    }
}
