package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.TreeSet;

public class Program {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        long start = System.currentTimeMillis();
        getMaxSubString(in);
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");

        start = System.currentTimeMillis();
        getMaxSubStringLC(in);
        end = System.currentTimeMillis();
        System.out.println("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }

    private static String getMaxSubString(String in) {
        TreeSet<String> set = new TreeSet<>();
        int len = in.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                set.add(in.substring(i, j));
            }
        }
        return set.last();
    }

    private static String getMaxSubStringLC(String in) {
        String max = "";
        int len = in.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String ss = in.substring(i, j);
                if (max.compareTo(ss) <= 0) {
                    max = ss;
                }
            }
        }
        return max;
    }
}
