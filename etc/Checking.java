package com.company.etc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Checking {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 6, 7, 8, 9, 1};
        System.out.println(numberOfPairs(a, 10));
    }

    static int numberOfPairs(int[] a, long k) {
        int pairs = 0;
        int n = a.length;
        Arrays.sort(a);
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (a[i] + a[j] == k) {
                while (i < j && a[i] == a[i + 1])
                    i++;
                while (i < j && a[j] == a[j - 1])
                    j--;
                pairs += 1;
                i++;
                j--;
            } else if (a[i] + a[j] < k)
                i++;
            else
                j--;
        }
        return pairs;
    }

}
