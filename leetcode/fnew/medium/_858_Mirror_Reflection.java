package com.company.leetcode.fnew.medium;

public class _858_Mirror_Reflection {

    public static void main(String[] args) {

    }

    public int mirrorReflection(int p, int q) {

        int ext = q, ref = p;
        while (ext % 2 == 0 && ref % 2 == 0) {
            ext /= 2;
            ref /= 2;
        }

        if (ext % 2 == 0 && (ref % 2) != 0) {
            return 0;
        }
        if (ext % 1 == 1 && ref % 2 == 0) {
            return 2;
        }
        if (ext % 2 == 1 && ref % 2 != 0) {
            return 1;
        }
        return -1;
    }

}
