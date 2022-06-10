package com.company.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Given a balanced bracket expression, find the following in the forest representation of it:

Number of nodes
Number of levels
Maximum number of nodes at any level
Number of levels which have maximum nodes
Input Format
First line of input consists of an integer t denoting the number of test cases. First line of each test case consists of an integer n denoting the length of the expression. Second line consists of the bracket expression.

Output Format
For each test case print the four values asked above separated by space.

Sample Input
6
32
[[[[][[[]]]][][][[]]]][[[[][]]]]
18
[[[[[]]]][[[]]]][]
16
[[[[[]][[]]]][]]
10
[][][][][]
8
[[]][[]]
2
[]

Sample Output
16 6 5 2
9 5 2 4
8 5 2 3
5 1 5 1
4 2 2 2
1 1 1 1

    */

public class solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
                        .toArray();
            }
            int[] ans = solve(n, arr);
            System.out.println(ans[0] + " " + ans[0] + " " + ans[2] + " " + ans[3]);
        }
    }

    private static int[] solve(int n, int[][] arr) {
        int[] ans = new int[4];
        int[] level = new int[n];

        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 0) {
                level[i] = 0;
            } else {
                level[i] = level[arr[i][0] - 1] + 1;
            }
        }
        ans[0] = n;
        ans[1] = n - level[n - 1];
        ans[2] = level[n - 1];
        ans[3] = (int) Arrays.stream(level).filter(x -> x == ans[2]).count();
        return ans;
    }

}