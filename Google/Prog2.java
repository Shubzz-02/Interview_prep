package com.company.Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Prog2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(Integer.parseInt(br.readLine())));
    }

    public static int solution(int total_lambs) {
        List<Double> list = new ArrayList<>();
        int x = 0;
        double rt = 0;
        while (x <= total_lambs) {
            double cv = Math.pow(2, x);
            list.add(cv);
            rt += cv;
            if (rt > total_lambs) break;
            x += 1;
        }
        List<Double> f = new ArrayList<>();
        f.add(1D);
        f.add(1D);
        double ft = 2D;
        int y = 2;
        while (y <= total_lambs) {
            double v = f.get(y - 1) + f.get(y - 2);
            f.add(v);
            ft += f.get(y);
            if (ft > total_lambs) break;
            y += 1;
        }
        int a = f.size() - list.size();
        return Math.abs(a);
    }
}
