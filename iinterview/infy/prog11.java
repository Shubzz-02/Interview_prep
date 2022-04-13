package com.company.iinterview.infy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class prog11 {
    public static void main(String[] args) {
        System.out.println(moduloGame("??????"));
    }

    public static int moduloGame(String s) {
        int n = s.length();
        int t = 0;
        String f = "%0" + n + "d";
        String pt = s.replaceAll("\\?", ".");
        long i = 7;
        while (i < n * 10000L) {
            String no = String.format(f, i);
            if (Pattern.matches(pt, no)) {
                t++;
            }
            i = i + 143;
        }
//        for (int i = 7; i < n * 10000; i++) {
//            if (i % (143) == 7) {
//                String no = String.format(f, i);
//                if (Pattern.matches(pt, no)) {
//                    t++;
//                }
//            }
//        }
        return (t % (109 + 7));
    }
}
