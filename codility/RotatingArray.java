package com.company.codility;

import java.util.Arrays;

public class RotatingArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SolutionRA().solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}, 4)));
    }
}

class SolutionRA {
    public int[] solution(int[] A, int K) {
        int[] a = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            a[(i + K) % A.length] = A[i];
        }
        return a;
    }
}
