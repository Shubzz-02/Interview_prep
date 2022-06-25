package com.company.codility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String inputData = br.readLine().trim();
        // Output the solution to the console
        List<String> ans = codeHere(inputData, n);
        ans.forEach(System.out::println);
    }

    public static List<String> codeHere(String inputData, int n) {
        // Use this function to write your solution;
        List<String> ans = new ArrayList<>();
        String[] arr = inputData.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int size = 0;
        while (i < arr.length) {
            size = size + arr[i].length();
            if (size <= n) {
                sb.append(arr[i]).append(" ");
                size++;
                i++;
            } else {
                ans.add(sb.toString().trim());
                size = 0;
                sb = new StringBuilder();
            }
        }
        return ans;
    }
}
