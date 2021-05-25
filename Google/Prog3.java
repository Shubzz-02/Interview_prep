package com.company.Google;

import java.util.Arrays;

public class Prog3 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 4, 1}));
    }

    public static int solution(int[] l) {
        int[] b0 = new int[10];
        int[] b1 = new int[10];
        int[] b2 = new int[10];
        int[] l1 = new int[10];
        int b0n = 0, b1n = 0, b2n = 0, l1n = 0, sum = 0;
        int ib1 = 0, ib2 = 0;
        for (int d : l) {
            sum += d;
            l1[l1n++] = d;
            if (d % 3 == 0)
                b0[b0n++] = d;
            else if (d % 3 == 1)
                b1[b1n++] = d;
            else if (d % 3 == 2)
                b2[b2n++] = d;
        }
        sort(b0, 0, b0n);
        sort(b1, 0, b1n);
        sort(b2, 0, b2n);
        if (sum % 3 == 0) {
            int i, res = 0;
            Arrays.sort(l1, 0, l1n);
            for (i = l1n - 1; i >= 0; i--) {
                res = res * 10 + l1[i];
            }
            return res;
        } else if (sum % 3 == 1) {
            if (b1n != 0)
                ib1++;
            else if (b2n >= 2)
                ib2 = ib2 + 2;
            else
                return 0;
        } else if (sum % 3 == 2) {
            if (b2n != 0)
                ib2++;
            else if (b1n >= 2)
                ib1 = ib1 + 2;
            else
                return 0;
        }
        int[] fnl = new int[20];
        int i, fn = 0, res = 0;
        for (i = 0; i < b0n; i++)
            fnl[fn++] = b0[i];
        for (i = ib1; i < b1n; i++)
            fnl[fn++] = b1[i];
        for (i = ib2; i < b2n; i++)
            fnl[fn++] = b2[i];
        sort(fnl, 0, fn);
        for (i = fn - 1; i >= 0; i--) {
            res = res * 10 + fnl[i];
        }
        return res;
    }


    private static void sort(int[] arr, int s, int e) {
        Arrays.sort(arr, s, e);
    }
}
