package com.company.Zoho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Program2 {
    /*
    0 4 5 3 7 2 1
    1 9 2 3 5 4 7 10
    5 3 9
     */
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int len = arr.length;
        for(int i=0;i<len;i++){
            if((arr[i] & 1) != 0){
                arr[i] *= -1;
            }
        }
        Arrays.sort(arr);
        for(int i=0;i<len;i++){
            if((Math.abs(arr[i]) & 1) != 0){
                arr[i] *= -1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
