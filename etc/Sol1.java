package com.company.etc;

public class Sol1 {

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 8, 8, 5, 6};
        System.out.println(Sol1.count_required_sequence(arr.length, arr));
    }

    static int count_required_sequence(int n, int[] arr) {
        int trs = 0;
        int tnrs = 0;
        int[][] dp = new int[10000][2];
        for (int i = 0; i < n; i++) {
            int tr = 0;
            for (int j = -1; j <= 1; j++) {
                tr += dp[arr[i] + j][0];
            }
            int rei = (trs
                    + tr);
            int nrei = (1 + tnrs
                    - tr);
            trs += rei;
            tnrs += nrei;
            dp[arr[i]][1] += rei;
            dp[arr[i]][0] += nrei;
        }

        return trs % (int)(Math.pow(10, 9) + 7);
    }
}
