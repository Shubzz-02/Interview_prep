package com.company.iinterview.infy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Prog5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine().trim();
        int len = in.length();
        System.out.println(getMaxChar(in, len));
    }

    private static char getMaxChar(String in, int len) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = in.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        AtomicReference<Character> ch = new AtomicReference<>('\0');
        AtomicInteger max = new AtomicInteger();
        map.forEach((k, v) -> {
            if (v > max.get()) {
                max.set(v);
                ch.set(k);
            }
        });
        return ch.get();
    }
}
