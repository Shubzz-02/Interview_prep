package com.company.leetcode.fnew.medium;

public class _1423_Maximum_Points_You_Can_Obtain_from_Cards {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 1};
        System.out.println(new _1423_Maximum_Points_You_Can_Obtain_from_Cards().maxScore(arr, 3));

    }

    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            sum += cardPoints[i];
        }

        int ans = 0, win = 0;
        int n = cardPoints.length;
        if (n == k) {
            return sum;
        }
        for (int i = 0; i < n - k - 1; i++) {
            win += cardPoints[i];
        }

        for (int i = n - k - 1; i < n; i++) {
            win += cardPoints[i];
            ans = Math.max(ans, sum - win);
            win -= cardPoints[i-(n - k - 1)];
        }
        return ans;
    }

}
