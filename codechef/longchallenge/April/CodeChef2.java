package com.company.codechef.longchallenge.April;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeChef2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            double[] in = Arrays.stream(br.readLine().trim().split(" ")).mapToDouble(Double::parseDouble).toArray();
            System.out.println(canBreakRecord(in[0], in[1], in[2], in[3]));
        }
    }

    private static String canBreakRecord(double k1, double k2, double k3, double v) {
        double fs = k1 * k2 * k3 * v;
        double tt = 100d / fs;
        // double d = 28786.079999999998;
        String str = String.format("%1.2f", tt);
        tt = Double.parseDouble(str);
        //System.out.println(d);
//        NumberFormat nf = NumberFormat.getInstance();
//        nf.setMaximumFractionDigits(2);
//        tt = Double.parseDouble(nf.format(tt));
        if (tt < 9.58) {
            return "Yes";
        } else
            return "No";
    }
}
