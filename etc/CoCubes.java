package com.company.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoCubes {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = RearrangeArray(Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray());
        System.out.println(Arrays.toString(arr));
    }

    static int[] RearrangeArray(int[] arr) throws java.lang.Exception {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0 && arr[i] >= 0) {
                int temp = i + 1;
                while (i < len) {
                    if (arr[i] <= 0) {
                        temp = i;
                        break;
                    }
                    i++;
                }
                if (i >= len)
                    break;
                else {
                    arr[i] = arr[temp];
                    shift(arr, i, temp);
                }
            }
        }
        return arr;
    }


    static void shift(int[] a, int i, int j) {

    }

}

/*

 */
