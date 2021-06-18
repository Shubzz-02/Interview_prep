package com.company.fftydsa.arrays;

import jdk.jfr.Description;
import jdk.jfr.Label;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question_4 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        new Solution_4().sort012HM(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}

@Label("Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.")
class Solution_4 {

    @Description("Using 3 pointer")
    public void sort012(int[] a, int n) {
        int l = 0, m = 0, r = n - 1;
        while (m <= r) {
            switch (a[m]) {
                case 0 -> {
                    a[l] = a[l] ^ a[m] ^ (a[m] = a[l]);
                    l++;
                    m++;
                }
                case 1 -> m++;
                case 2 -> {
                    a[m] = a[m] ^ a[r] ^ (a[r] = a[m]);
                    r--;
                }
            }
        }
    }

    @Description("Using HashMap")
    public void sort012HM(int[] a, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);

        for (int i : a) {
            if (i == 0)
                map.put(0, map.get(0) + 1);
            else if (i == 1)
                map.put(1, map.get(1) + 1);
            else
                map.put(2, map.get(2) + 1);
        }

        int s = 0;
        int[] aa = new int[a.length];
        for (int i = 0; i <= 2; i++) {
            for (int ii = s; ii < s + map.get(i); ii++)
                aa[ii] = i;
            // Arrays.fill(a, s, s+map.get(i) , i);
            s = map.get(i);
        }
        System.out.println(Arrays.toString(aa));
        a = aa;
    }
}
