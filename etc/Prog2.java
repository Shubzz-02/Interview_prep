package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Prog2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int in = Integer.parseInt(br.readLine());
        System.out.println(isHappy(in));
    }

    private static boolean isHappy(int in) {
        Set<Integer> set = new HashSet<>();
        set.add(in);
        while (true) {
            in = square(in);
            if (in == 1)
                return true;
            else if (!set.contains(in))
                set.add(in);
            else
                return false;
        }
    }

    private static int square(int in) {
        int sum = 0;
        while (in > 0) {
            int d = in % 10;
            sum += Math.pow(d, 2);
            in /= 10;
        }
        return sum;
    }
}
