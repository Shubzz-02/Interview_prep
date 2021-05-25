package com.company.codechef.longchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeChef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] dc = br.readLine().trim().split(" ");
            String[] d1 = br.readLine().trim().split(" ");
            String[] d2 = br.readLine().trim().split(" ");
            System.out.println(shouldBuy(dc, d1, d2));
        }
    }

    private static String shouldBuy(String[] dc, String[] d1, String[] d2) {
        int d1sum = 0;
        int d2sum = 0;
        for (int i = 0; i < 3; i++) {
            d1sum += Integer.parseInt(d1[i]);
            d2sum += Integer.parseInt(d2[i]);
        }
        int woc = d1sum + d2sum + 2 * Integer.parseInt(dc[0]);
        int wc = d1sum + d2sum;
        if (d1sum >= 150 && d2sum >= 150)
            wc += Integer.parseInt(dc[1]);
        else if (d1sum < 150 && d2sum < 150) {
            wc += 2 * Integer.parseInt(dc[0]);
        } else {
            wc += Integer.parseInt(dc[1]) + Integer.parseInt(dc[0]);
        }
        if(woc <= wc){
            return "NO";
        }else
            return "YES";
    }
}
