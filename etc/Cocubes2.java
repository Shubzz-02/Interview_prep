package com.company.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Cocubes2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr = ProductSmallestPair(Integer.parseInt(br.readLine()), Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray());
        System.out.println(arr);
    }

    static int ProductSmallestPair(int sum, int[] arr) throws java.lang.Exception {
        int len = arr.length;
        if (len < 2)
            return -1;
        Arrays.sort(arr);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if(arr[i] + arr[j] <= sum)
                    return (arr[i]*arr[j]);
            }
        }
        return 0;
    }
}
