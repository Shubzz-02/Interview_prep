package com.company.codechef.longchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CodeChef5 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] in = br.readLine().trim().split(" ");
            Set<String> set = new HashSet<>(Arrays.asList(in));
            System.out.println(possibleTeamName(in, n, set));
        }
    }

    private static int possibleTeamName(String[] in, int n, Set<String> set) {
        Arrays.sort(in);
        int uw = 0;
        if (in[0].charAt(0) == in[n - 1].charAt(0))
            return 0;
        for (int i = 0; i < n; i++) {
            int j = n - 1;
            while (j > i && (in[i].charAt(0) != in[j].charAt(0))) {
                String fu = in[j].charAt(0) + in[i].substring(1);
                if (!set.contains(fu)) {
                    String su = in[i].charAt(0) + in[j].substring(1);
                    if (!set.contains(su))
                        uw += 2;
                }
                j--;
            }
        }
        return (uw);
    }



}
