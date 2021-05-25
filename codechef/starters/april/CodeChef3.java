package com.company.codechef.starters.april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeChef3 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            int[] nm =  Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();;
            int[] xy =  Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] ab =  Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(canEscape(nm[0],nm[1],xy[0],xy[1],ab[0],ab[1]));
        }
    }

    private static String canEscape(int n, int m, int x, int y, int a, int b) {
        int th = (n-x)+(m-y);
        int po = (n-a)+(m-b)-Math.min(n-a,m-b);
        if(th <= po)
            return "YES";
        else
            return "NO";
    }
}
