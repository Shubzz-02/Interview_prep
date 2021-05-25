package com.company.codechef.longchallenge;

import java.io.IOException;
import java.util.Scanner;

public class CodeChef1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(highestDivisorUnderTen(n));
    }

    private static int highestDivisorUnderTen(int n) {
        for (int i = 10; i >= 1; i--) {
            if(n%i == 0)
                return i;
        }
        return 1;
    }
}
