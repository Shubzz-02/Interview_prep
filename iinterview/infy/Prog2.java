package com.company.iinterview.infy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prog2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        int ind = Integer.parseInt(br.readLine());
        System.out.println(charAtIndex(in, ind));
    }

    private static char charAtIndex(String in, int ind) {
        int len = in.length();
        int i = 0, e = 0;
        StringBuilder sb = new StringBuilder();
        while (e < len) {
            StringBuilder n = new StringBuilder();
            if (in.charAt(e) >= 48 && in.charAt(e) <= 57) {
                while (e < len && in.charAt(e) <= 57) {
                    n.append(in.charAt(e));
                    e++;
                }
                String ex = in.substring(i, e - n.length());
                sb.append(ex.repeat(Math.max(0, Integer.parseInt(n.toString()))));
                i = e;
            } else {
                e++;
            }
        }
        return sb.charAt(ind);
    }



}

/*
a1b1

 */
