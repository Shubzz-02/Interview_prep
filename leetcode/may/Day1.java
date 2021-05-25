package com.company.leetcode.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Day1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        WordFilter obj = new WordFilter(new String[]{"apple"});
        System.out.println(obj.f("a", "e"));
    }
}

class WordFilter {
    String[] dict;

    Map<Integer,String> map;
    public WordFilter(String[] words) {
        map = new HashMap<>();
        for(String i : words){

        }

    }

    public int f(String prefix, String suffix) {
        int t = -1;
        for (int i = 0; i < dict.length; i++) {
            if (dict[i].startsWith(prefix) && dict[i].endsWith(suffix))
                t = i;
        }
        return t;
    }
}
