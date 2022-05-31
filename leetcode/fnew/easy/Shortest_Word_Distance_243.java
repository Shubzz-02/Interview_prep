package com.company.leetcode.fnew.easy;

public class Shortest_Word_Distance_243 {

    public static void main(String[] args) {
        String[] wordDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding", word2 = "practice";
        System.out.println(
                new Shortest_Word_Distance_243().shortestDistance(wordDict, word1, word2));
    }

    public int shortestDistance(String[] wordsDict, String word1, String word2) {

        int w1 = -1, w2 = -1;
        int min = wordsDict.length;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                w1 = i;
            } else if (wordsDict[i].equals(word2)) {
                w2 = i;
            }
            if (w1 != -1 && w2 != -1) {
                min = Math.min(min, Math.abs(w1 - w2));
            }
        }
        return min;
    }

}
