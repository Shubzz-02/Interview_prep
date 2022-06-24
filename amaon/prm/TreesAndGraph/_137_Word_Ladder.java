package com.company.amaon.prm.TreesAndGraph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class _137_Word_Ladder {

    public static void main(String[] args) {

        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});

        System.out.println(new _137_Word_Ladder().ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> wordListSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();

        queue.add(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int s = 0; s < size; s++) {
                String cw = queue.remove();
                if (cw.equals(endWord)) {
                    return level;
                }

                char[] arr = cw.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char ch = arr[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        arr[i] = j;
                        String temp = new String(arr);
                        if (!visited.contains(temp) && !temp.equals(beginWord)
                                && wordListSet.contains(temp)) {
                            visited.add(temp);
                            queue.add(temp);
                        }
                    }
                    arr[i] = ch;
                }
            }
        }
        return 0;
    }

}
