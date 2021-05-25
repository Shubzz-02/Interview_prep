package com.company.iinterview.infy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Prog6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        //pattern(in);
        System.out.println(checkPassword(in, in.length()));
    }

    private static void pattern(String in) {
        int len = in.length();
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len - i; j++) {
                System.out.print(" ");
            }
            System.out.println(in.substring(0, i));
        }
        for (int i = 1; i < len; i++) {
            System.out.print(in.substring(i));
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static int checkPassword(String in, int n) {
        if (n < 4) {
            return 0;
        }
        if (in.charAt(0) >= '0' && in.charAt(0) <= '9') {
            return 0;
        }
        int num = 0, cp = 0;
        for (int i = 0; i < n; i++) {
            char ch = in.charAt(i);
            if (ch >= '0' && ch <= '9')
                num++;
            else if (ch >= 'A' && ch <= 'Z')
                cp++;
            else if (ch == ' ' || ch == '/')
                return 0;
        }
        if (num > 0 && cp > 0)
            return 1;
        else
            return 0;
    }
}
