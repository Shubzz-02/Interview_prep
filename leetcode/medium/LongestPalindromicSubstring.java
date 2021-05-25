package com.company.leetcode.medium;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new SolutionLP().longestPalindrome("babad"));
    }
}

class SolutionLP {
    public String longestPalindrome(String s) {
        int len = s.length();
        int max = 1;
        int start = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i != len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                max = 2;
            }
        }

        for (int k = 3; k <= len; k++) {
            for (int i = 0; i < len - k + 1; i++) {
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (k > max) {
                        start = i;
                        max = k;
                    }
                }
            }
        }
        return s.substring(start, start + max);
    }
}


/*

//        for (boolean[] r : dp) {
//            for (boolean c : r) {
//                System.out.print(c+" ");
//            }
//            System.out.println();
//        }


 public String longestPalindrome(String s) {
        String res = "";
        int longRes = 0;
        int len = s.length();
        if (len == 2)
            if (s.charAt(0) == s.charAt(1))
                return s;
            else
                return String.valueOf(s.charAt(0));
        for (int i = 0; i < len; i++) {
            if (len % 2 != 0) {
                String[] got = getLongRes(s, longRes, len, i, i, res);
                longRes = Integer.parseInt(got[1]);
                res = got[0];
            } else {
                int r = i + 1;
                String[] got = getLongRes(s, longRes, len, i, r, res);
                longRes = Integer.parseInt(got[1]);
                res = got[0];
            }
        }
        return res;
    }

    private String[] getLongRes(String s, int longRes, int len, int l, int r, String pRes) {
        String res = pRes;
        while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
            if (r - l + 1 > longRes) {
                res = s.substring(l, r + 1);
                longRes = r - l + 1;
            }
            l--;
            r++;
        }
        return new String[]{res, String.valueOf(longRes)};
    }
 */
