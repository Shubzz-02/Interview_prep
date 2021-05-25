package com.company.etc;

public class XlsNumberToChar {
    public static void main(String[] args) {
        System.out.println(convertToTitle(25));
    }

    public static String convertToTitle(int n) {
        int q = n / 26;
        int r = n % 26;
        StringBuilder s = new StringBuilder();
        while (q > 0 || r > 0) {
            if (q > 0 && r == 0) {
                s.insert(0, 'Z');
                q--;
            } else {
                s.insert(0, (char) ('A' - 1 + r));
            }
            n = q;
            q = n / 26;
            r = n % 26;
        }
        return s.toString();
    }
}
