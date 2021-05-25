package com.company.etc;

public class ExtractBit {
    public static void main(String[] args) {
        System.out.println(countSetBits(128));

    }

    private static int countSetBits(int s) {
        System.out.println(s );
        System.out.println(s& (s-1));
        System.out.println(s >> 1);
        return 0;
    }

    static void decToBinary(int n)
    {
        int[] binaryNum = new int[32];
        int i = 0;
        while (n > 0) {
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }
        for (int j = i - 1; j >= 0; j--)
            System.out.print(binaryNum[j]);
    }
}
