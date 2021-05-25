package com.company.codechef.longchallenge.march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeChef5 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] in = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(minimumOrder(in[0], in[1], in[2], in[3], in[4], in[5]));
        }
    }

    private static long minimumOrder(int n, int e, int h, int a, int b, int c) {
        List<Long> ans = new ArrayList<>();
        List<Long> val = new ArrayList<>();
        for (int i = 0; i <= n + 1; i++) {
            val.add((long) i);
            for (long m = 0; m <= n; m++) {
                long it1 = lower_bound(val, (2L * n - e - 2 * m) - val.get(0));
                long it2 = upper_bound(val, (h - 3 * m) - val.get(0) - 1);
                if (it2 < it1 || it1 == n + 1) continue;
                if (it2 == n + 1 && it2 + 3 * m > h) continue;
                long k;
                if (c > a) k = (Math.min(it1, (n - m)));
                else k = (Math.min(it2, (n - m)));
                long o = n - k - m;
                if (k + 2 * m >= 2L * n - e && k + 3 * m <= h) {
                    ans.add(a * o + b * m + c * k);
                }
            }
        }
        if (ans.size() == 0)
            return -1;
        else {
            long min = ans.get(0);
            for (Long aLong : ans) {
                if (aLong < min)
                    min = aLong;
            }
            return min;
        }
    }

    private static long lower_bound(List<Long> ar, long k) {
        long s = 0;
        int e = ar.size();
        while (s != e) {
            int mid = (int) (s + e >> 1);
            if (ar.get(mid) < k) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        if (s == ar.size()) {
            return -1;
        }
        return s;
    }

    private static long upper_bound(List<Long> ar, long k) {
        long s = 0;
        int e = ar.size();
        while (s != e) {
            int mid = (int) (s + e >> 1);
            if (ar.get(mid) <= k) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        if (s == ar.size()) {
            return -1;
        }
        return s;
    }

}
