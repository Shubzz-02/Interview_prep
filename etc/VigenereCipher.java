package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class VigenereCipher {

    private static String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            int shift = (int) key.charAt(i % key.length()) - 65;
            c = (char) ((c + shift - 65) % 26 + 65);
            ciphertext.append(c);
        }

        return ciphertext.toString();
    }

    private static String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            int shift = (int) key.charAt(i % key.length()) - 65;
            c = (char) ((c - shift - 65 + 26) % 26 + 65);
            plaintext.append(c);
        }

        return plaintext.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String key = "T#G5RT*K$2LQJW9";
        int ch = 0;
        do {
            System.out.print("Enter choice: ");
            ch = Integer.parseInt(br.readLine());
            if (ch == 0) {
                System.out.print("Enter plaintext: ");
                String plaintext = br.readLine().toUpperCase();
                String ciphertext = encrypt(plaintext, key);
                System.out.println("Ciphertext: " + ciphertext);
            } else {
                System.out.print("Enter ciphertext: ");
                String ciphertext = br.readLine().toUpperCase();
                String decryptedText = decrypt(ciphertext, key);
                System.out.println("Decrypted Text: " + decryptedText);
            }
        } while (ch != 3);

        System.out.print("Enter key: ");


    }

}
