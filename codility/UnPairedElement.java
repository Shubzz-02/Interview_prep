package com.company.codility;

public class UnPairedElement {
}

class SolutionUE {
    public int solution(int[] A) {
        int xor = 0;
        for (int i : A) {
            xor ^= i;
        }
        return xor;
    }
}
