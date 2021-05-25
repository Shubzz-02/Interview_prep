package com.company.codility;

import java.util.stream.Stream;

public class Question1 {
    public static void main(String[] args) {
        new Solution().solution();
//        System.out.println(new Solution().solution(5));
//        System.out.println(Math.max(-999, -5999));
    }
}

class Solution {
    public void solution() {
        Stream<Integer> numStream = Stream.of(10, 20, 30);
        numStream.map(n -> n + 10).peek(System.out::print);
        // numStream.forEach(s -> System.out.println(s));
    }

    public int solution(int n) {
        int sign;
        if (n < 0) {
            n = n * -1;
            sign = -1;
        } else {
            sign = 1;
        }
        String act = String.valueOf(n);
        boolean found = false;
        if (sign == 1) {
            for (int i = 0; i < act.length(); i++) {
                if (act.charAt(i) - '0' < 5) {
                    act = act.substring(0, i) + "5" + act.substring(i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                act = act + "5";
            }
        } else {
            for (int i = 0; i < act.length(); i++) {
                if (act.charAt(i) - '0' > 5) {
                    act = act.substring(0, i) + "5" + act.substring(i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                act = "5" + act;
            }
        }
        n = Integer.parseInt(act);
        n = n * sign;
        return n;
    }



}
/*
if (num.charAt(0) != '-') {
            for (int i = 0; i < len; i++) {
                if ((int) num.charAt(i) <= (int)'5') {
                    String ans = num.substring(0, i) + '5' + num.substring(i);
                    return Integer.parseInt(ans);
                }
            }
        } else {
            for (int i = 0; i < len; i++) {
                if ((int) num.charAt(i) > (int)'5') {
                    String ans = '-' + num.substring(1, i) + '5' + num.substring(i);
                    return Integer.parseInt(ans);
                }
            }
        }
        return N;
 */
