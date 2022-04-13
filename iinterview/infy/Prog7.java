package com.company.iinterview.infy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prog7 {

    public static void main(String[] args) throws IOException {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(
                Arrays.asList(1, 5)
        ));
        list.add(new ArrayList<>(
                Arrays.asList(2, 1)
        ));
        System.out.println(palindromeMaking(list.size(), list.get(0).size(), list));
    }


    public static int palindromeMaking(int N, int M, List<List<Integer>> arr) {
        int sum = 0;
        int j = 0;
        int[][] p = {
                {0, 0},
                {0, M - 1},
                {N - 1, 0},
                {N - 1, M - 1}
        };
        int i1 = ((M ^ 1) == M + 1) ? M / 2 - 1 : M / 2;
        while (j <= i1) {
            int s = 0;
            for (int[] ints : p) {
                s += arr.get(ints[0]).get(ints[1]);
            }
            s /= 4;
            sum = getSum(arr, sum, p, s);
            p[2] = new int[]{p[2][0], p[2][1] + 1};
            p[3] = new int[]{p[3][0], p[3][1] - 1};
            j++;
        }

        j = 1;
        p = new int[][]{
                {1, 0},
                {1, M - 1}
        };
        while (j < N - 1) {
            int i = 0;
            while (i <= i1) {
                int s = 0;
                for (int[] ints : p) {
                    s += arr.get(ints[0]).get(ints[1]);
                }
                s /= 2;
                sum = getSum(arr, sum, p, s);
                i++;
            }
            j++;
        }
        return sum;
    }

    private static int getSum(List<List<Integer>> arr, int sum, int[][] p, int s) {
        for (int i = 0; i < p.length; i++) {
            if (i == 0 || !Arrays.equals(p[i], p[i - 1])) {
                sum += Math.abs(arr.get(p[i][0]).get(p[i][1]) - s);
            }
        }
        p[0] = new int[]{p[0][0], p[0][1] + 1};
        p[1] = new int[]{p[1][0], p[1][1] - 1};
        return sum;
    }


}
