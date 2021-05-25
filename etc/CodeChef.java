package com.company.etc;

import java.util.Scanner;

public class CodeChef {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            String string = s.next();
            System.out.println(isValid(string));
        }
    }

    private static String isValid(String string) {
        if (string.length() < 10) {
            return "NO";
        }

        int len = string.length();

        int sl = 0, cl = 0, n = 0, sc = 0;
        for (int i = 0; i < len; i++) {
            char ch = string.charAt(i);
            if (ch >= 65 && ch <= 90) {
                cl++;
            } else if (ch >= 97 && ch <= 122) {
                sl++;
            } else if (ch >= 48 && ch <= 57) {
                n++;
            } else if (ch == '@' || ch == '#' || ch == '%' || ch == '&' || ch == '?') {
                sc++;
            } else {
                return "NO";
            }
        }

        if (cl > 0 && sl > 0 && n > 0 && sc > 0) {
            if (n == 1 && ((string.charAt(0) >= 48 && string.charAt(0) <= 57) || (string.charAt(len - 1) >= 48 && string.charAt(len - 1) <= 57))) {
                return "NO";
            }
            if (sc == 1 &&
                    ((string.charAt(0) == '@' || string.charAt(0) == '#' || string.charAt(0) == '%' ||
                            string.charAt(0) == '&' || string.charAt(0) == '?') || (string.charAt(len - 1) == '@' || string.charAt(len - 1) == '#' || string.charAt(len - 1) == '%' ||
                            string.charAt(len - 1) == '&' || string.charAt(len - 1) == '?'))) {
                return "NO";
            }
            if (cl == 1 && ((string.charAt(0) >= 65 && string.charAt(0) <= 90) || (string.charAt(len - 1) >= 65 && string.charAt(len - 1) <= 90))) {
                return "NO";
            }
        } else {
            return "NO";
        }

        return "YES";
    }
}
