package com.company.codechef.longchallenge.April;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeChef6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] nmk = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            long[][] arr = new long[nmk[0] + 1][nmk[1] + 1];
            arr[0] = Arrays.stream(generateZero(nmk[1]).trim().split(" ")).mapToLong(Long::parseLong).toArray();
            for (int i = 1; i <= nmk[0]; i++) {
                arr[i] = Arrays.stream(("0 " + br.readLine()).trim().split(" ")).mapToLong(Long::parseLong).toArray();
            }
//            for (double[] i : arr)
//                System.out.println(Arrays.toString    (i));
            System.out.println(findWorthyMatrix(nmk[0], nmk[1], nmk[2], arr));
        }
    }

    static String generateZero(int m) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= m; i++) {
            sb.append("0 ");
        }
        return sb.toString();
    }

    private static long findWorthyMatrix(int n, int m, int k, long[][] arr) {
        long p;
        for (int i = 0; i <= n; i++) {
            p = 0;
            for (int j = 0; j <= m; j++) {
                arr[i][j] += p;
                p = arr[i][j];
            }
        }
        for (int i = 0; i <= m; i++) {
            p = 0;
            for (int j = 0; j <= n; j++) {
                arr[j][i] += p;
                p = arr[j][i];
            }
        }
        int z = Math.min(n, m);
        long ans = 0L;
        for (int i = 1; i <= z; i++) {
            for (int j = i; j <= n; j++) {
                for (int l = i; l <= m; l++) {
                    if ((arr[j][l] + arr[j - i][l - i] - arr[j][l - i] - arr[j - i][l]) / ((long) i * i) >= k)
                        ans++;
                }
            }
        }
        return ans;
    }
}



/*
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] nmk = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            double[][] arr = new double[nmk[0] + 1][nmk[1] + 1];
            arr[0] = Arrays.stream(generateZero(nmk[1]).trim().split(" ")).mapToDouble(Double::parseDouble).toArray();
            for (int i = 1; i <= nmk[0]; i++) {
                arr[i] = Arrays.stream(("0 " + br.readLine()).trim().split(" ")).mapToDouble(Double::parseDouble).toArray();
            }
//            for (double[] i : arr)
//                System.out.println(Arrays.toString(i));
            System.out.println(findWorthyMatrix(nmk[0], nmk[1], nmk[2], arr));
        }
    }

    static String generateZero(int m) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= m; i++) {
            sb.append("0 ");
        }
        return sb.toString();
    }

    private static long findWorthyMatrix(int n, int m, int k, double[][] arr) {
        double p = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                arr[i][j] += p;
                p = arr[i][j];
            }
        }
        p = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                arr[j][i] += p;
                p = arr[j][i];
            }
        }
        long z = Math.min(n, m), ans = 0;
        for (int i = 1; i <= z; i++) {
            for (int j = i; j <= n; j++) {
                for (int l = i; l <= m; l++) {
                    if ((arr[j][l] + arr[j - i][l - i] - arr[j][l - i] - arr[j - i][l]) / (i * i) >= k)
                        ans++;
                }
            }
        }
        return ans;
    }
}
 */
