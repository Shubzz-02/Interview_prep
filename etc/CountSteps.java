package com.company.etc;

public class CountSteps {
    public static int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

    public static void main(String[] args) {
//        for i := 0; i < 10; i++ {
//            x += i
//        }

                System.out.println(climbStairs(5));


        System.out.println(check(null,null));


    }


    static boolean check(CountSteps p, CountSteps q) {
        return (p == null || q == null);
    }
}
