package com.company.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class solution1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            int[] totalVolume = Arrays.stream(bufferedReader.readLine().trim().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] initialWater = Arrays.stream(bufferedReader.readLine().trim().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int[] ans = solve(n, totalVolume, initialWater);
            System.out.println(ans[1] + " " + ans[0]);
        }
    }

    private static int[] solve(int n, int[] totalVolume, int[] initialOil) {

        int totalOilCollected = initialOil[0];
        int totalOilSpilled = 0;
        for (int i = 1; i < totalVolume.length; i++) {
            totalOilCollected += initialOil[i];
            if (totalOilCollected > totalVolume[i]) {
                int cs = totalOilCollected - totalVolume[i];
                totalOilSpilled += cs;
                totalOilCollected = totalOilCollected - cs;
            }
        }
        return new int[]{totalOilSpilled, totalOilCollected};
    }

}
