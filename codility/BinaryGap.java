package com.company.codility;

import java.io.IOException;

public class BinaryGap {
    public static void main(String[] args) throws IOException {
        // for (int i = 1; i <= 50; i++)
        System.out.println(new SolutionBG().solution(1041));
//        for (int i = 0; i <= 32; i++) {
//            System.out.print((1 << i) + " ");
//        }
    }
}
//10000000000000000000000000000000

class SolutionBG {
    public int solution(int N) {
        System.out.println(Integer.toBinaryString(N));
        int last = -1, ans = 0;
        for (int i = 0; i < 32; ++i) {
            if (((N >> i) & 1) > 0) {
                if (last >= 0)
                    ans = Math.max(ans, i - last);
                last = i;
            }
        }
        return ans;
    }
}
