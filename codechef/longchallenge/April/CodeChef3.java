package com.company.codechef.longchallenge.April;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeChef3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] kn = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            String s = br.readLine();
            System.out.println(isStrongLanguage(kn[0], kn[1], s));
        }
    }

    private static String isStrongLanguage(int n, int k, String s) {
        if (k > n)
            return "No";
        else {
            int i = 0;
            int ct = 0;
            while (i < n) {
                int j = i + 1;
                if (s.charAt(i) == '*') {
                    ct = 1;
                    while (j < n)
                        if (s.charAt(j) == '*') {
                            ct++;
                            j++;
                        } else
                            break;
                }
                if (ct >= k)
                    return "Yes";
                i = j;
            }
        }
        return "No";
    }
}
