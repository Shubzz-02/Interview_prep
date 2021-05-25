package com.company.leetcode.misc;

public class REWithGE {
    public static void main(String[] args) {
        int[] arr = {400};
        new SolutionRG().replaceElements(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }

}

class SolutionRG {
    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int msf = arr[len - 1];
        arr[len - 1] = -1;
        for (int i = len - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = msf;
            msf = Math.max(msf, temp);
        }
        return arr;
    }
}
