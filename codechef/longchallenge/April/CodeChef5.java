package com.company.codechef.longchallenge.April;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeChef5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());
            System.out.println(findMaxPossible(n));
        }
    }

    private static long findMaxPossible(long n) {
        long m = n / 4;
        long r = n % 4;
        long ans = 0;
        if (n == 1)
            ans = 20;
        else if (n == 2)
            ans = 2 * (6 + 5 + 4 + 3);
        else if (n == 3)
            ans = 2 * (6 + 5 + 4 + 3) + 6 + 5 + 4;
        else if (n >= 4) {
            if (r == 0) {
                ans += 4 * (6 + 5) * m;
                ans += 4 * 4;
            } else if (r == 1) {
                ans += 4 * (6 + 5) * m;
                ans += 3 * 4;
                ans += 6 + 5 + 4 + 3 + 2;
            } else if (r == 2) {
                ans += 4 * (6 + 5) * m;
                ans += 2 * 4;
                ans += 2 * (6 + 5 + 4 + 3);
            } else if (r == 3) {
                ans += 4 * (6 + 5) * m;
                ans += 4;
                ans += 2 * (6 + 4 + 3 + 5) + 6 + 5 + 4;
            }
        }
        return ans;
    }
}
