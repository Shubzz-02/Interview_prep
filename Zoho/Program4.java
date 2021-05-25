package com.company.Zoho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Program4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] lm = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i < n; i++)
            arr[i] += arr[i - 1];
        System.out.println(max(maxSum(arr,lm[0],lm[1],n),maxSum(arr,lm[1],lm[0],n)));
    }

    private static int maxSum(int[] arr, int l, int m, int n) {
        int[] left = new int[n];
        int[] right = new int[n];
        int a = n-m-1,mx = 0;
        right[n-m] = arr[n-1]-arr[a];
        left[l - 1] = arr[l - 1];
        for (int i = l; i < n; i++) {
            left[i] = max(arr[i]-arr[i-l],left[i-1]);
        }
        for(int i=a;i>0;i--){
            right[i] = max(right[i+1],arr[i+m-1]-arr[i-1]);
        }
        right[0] = max(arr[m-1],right[1]);
        for(int i=0;i<n-1;i++){
            mx = max(mx,left[i]+right[i+1]);
        }
        return mx;
    }

    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}

/*
9
0 6 5 2 2 5 1 9 4
1 2

9
3 8 2 3 2 1 8 9 0
3 2

10
2 1 2 3 5 6 1 0 8 9
4 2
 */
