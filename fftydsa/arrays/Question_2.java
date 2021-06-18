package com.company.fftydsa.arrays;

import jdk.jfr.Description;
import jdk.jfr.Label;

import java.util.Arrays;

public class Question_2 {
    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        //int[] nm = new Solution_2().maxMin(arr, arr.length);
//        int[] nm = new Solution_2().maxMin(arr, 0, arr.length - 1);
        int[] nm = new Solution_2().maxMin3(arr, arr.length);
        System.out.println(Arrays.toString(nm));
    }
}


@Label("Return minimum and maximum in an array. Your program should make the minimum number of comparisons. ")
class Solution_2 {

    @Description("Linear Search Approach MAX no of comparison")
    public int[] maxMin(int[] arr, int len) {
        int[] ans = new int[2];
        ans[0] = Integer.MAX_VALUE;
        ans[1] = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (arr[i] < ans[0]) ans[0] = arr[i];
            else if (arr[i] > ans[1]) ans[1] = arr[i];
        }
        return ans;
    }

    @Description("Tournament Method")
    public int[] maxMin(int[] arr, int left, int right) {
        int[] ans = new int[2];
        if (left == right) {
            ans[1] = arr[left];
            ans[0] = arr[left];
            return ans;
        }

        if (left == right + 1) {
            ans[0] = Math.min(arr[left], arr[right]);
            ans[1] = Math.max(arr[left], arr[right]);
            return ans;
        }

        int mid = (left + right) >>> 1;
        int[] mml = maxMin(arr, left, mid);
        int[] mmr = maxMin(arr, mid + 1, right);

        ans[0] = Math.min(mml[0], mmr[0]);
        ans[1] = Math.max(mml[1], mmr[1]);

        return ans;
    }

    @Description("Compare")
    public int[] maxMin3(int[] arr, int len) {
        int[] ans = new int[2];
        int i;
        if ((len & 1) == 0) {
            ans[0] = Math.min(arr[0], arr[1]);
            ans[1] = Math.max(arr[0], arr[1]);
            i = 2;
        } else {
            ans[1] = arr[0];
            ans[0] = arr[0];
            i = 1;
        }

        while (i < len - 1) {
            ans[0] = Math.min(ans[0], Math.min(arr[i], arr[i + 1]));
            ans[1] = Math.max(ans[1], Math.max(arr[i], arr[i + 1]));
            i += 2;
        }
        return ans;
    }
}
