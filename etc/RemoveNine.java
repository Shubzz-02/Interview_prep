package com.company.etc;

public class RemoveNine {
    public static void main(String[] args) {
        long n = 12L;
        System.out.println(fnidNth(n));
    }

    private static long fnidNth(long n) {
        long result=0;
        long p=1;
        while(n>0){
            result+=(p*(n%9));
            n=n/9;
            p=p*10;
        }
        return result;
    }
}
