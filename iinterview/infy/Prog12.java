package com.company.iinterview.infy;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

public class Prog12 {
    public static void main(String[] args) throws IOException, ParseException {

        File file = new File("src/Number.txt");
        if (!file.exists()) {
            System.out.println("File not found.");
            System.exit(0);
        }

        Scanner sc = new Scanner(new File("src/Number.txt"));

        System.out.println("Writes out numbers from the file so the user can se them");

        int[] arr = Arrays.stream(sc.nextLine().trim().split(";")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        int min = arr[0];


        sc.close();

        System.out.println("Smallest number: " + min);
        System.out.println("Largest number: " + max);
    }

    private static int oddXor(int n, int[] ar, int q, int[] left, int[] right) {
        return 0;
    }


}
