package com.company.codechef.starters.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeChef3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] nm = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] f = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] c = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            //System.out.println(Arrays.toString(f) + "\n" + Arrays.toString(c));
            System.out.println(countTotalSwitch(nm, f, c));
        }
    }

    private static int countTotalSwitch(int[] nm, int[] f, int[] c) {
        int ts = 0, i = 0, j = 0;
        char ch = 'i';
        for (int k = 0; k < nm[0] + nm[1]; k++) {

            if (i >= nm[0] && j < nm[1] && ch == 'i') {
                ts++;
                break;
            } else if (j >= nm[1] && i < nm[0] && ch == 'j') {
                ts++;
                break;
            }
            if (f[i] < c[j] && ch == 'i') {
                i++;
            } else if (f[i] < c[j] && ch == 'j') {
                ts++;
                i++;
                ch = 'i';
            } else if (c[j] < f[i] && ch == 'j') {
                j++;
            } else if (c[j] < f[i] && ch == 'i') {
                ts++;
                j++;
                ch = 'j';
            }
        }
        return ts;
    }
}
