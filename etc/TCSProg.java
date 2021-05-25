package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TCSProg {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] stock = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        //printDays(n, stock);
        System.out.println(Arrays.toString(printDaysOP(n, stock)).replaceAll("[^0-9]", " ").trim());
    }


    private static int[] printDaysOP(int n, int[] stock) {
        int[] out = new int[n];
        for (int i = 0; i < n; i++) {
            int ct = 0;
            int j = i;
            while (j >= 0) {
                if (stock[i] >= stock[j]) {
                    if (out[j] > 0) {
                        ct += out[j];
                        j -= out[j];
                    } else {
                        ct++;
                        j--;
                    }
                } else {
                    break;
                }
            }
            out[i] = ct;
        }
        return out;
    }
}

//    private static void printDays(int n, int[] stock) {
//        for (int i = 0; i < n; i++) {
//            int ct = 0;
//            for (int j = i; j >= 0; j--) {
//                if (stock[i] >= stock[j])
//                    ct++;
//                else
//                    break;
//            }
//            System.out.print(ct + " ");
//        }
//    }


//            for (int j = i; j >= 0; j--) {
//                if (stock[i] >= stock[j]) {
//                    if (out[j] > 0)
//                        ct += out[j];
//                    else
//                        ct++;
//
//                } else
//                    break;
//            }
