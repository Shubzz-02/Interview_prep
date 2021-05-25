package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Cogniz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] lr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(getMaxPrime(lr[0], lr[1]));
        }
    }

    private static int getMaxPrime(int l, int r) {
        int min = -1;
        int max = -1;
        int ct = l;
        while (l <= r) {
            if (isPrime(l)) {
                min = l;
                break;
            } else {
                l++;
            }
        }
        while (r >= l) {
            if (isPrime(r)) {
                max = r;
                break;
            } else {
                r--;
            }
        }
        if ((min != -1 && max != -1) && min == max)
            return 0;
        else if (max == -1 && min == -1)
            return -1;
        else
            return max - min;
    }

    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
