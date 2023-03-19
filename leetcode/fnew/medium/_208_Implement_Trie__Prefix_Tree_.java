package com.company.leetcode.fnew.medium;

import java.util.Arrays;

public class _208_Implement_Trie__Prefix_Tree_ {


    public static void main(String[] args) {

    }


}

class TrieNode {

    boolean isEndOfWord;

    TrieNode[] node;
    char ch;

    TrieNode() {
        ch = '\0';
        isEndOfWord = false;
        node = new TrieNode[26];
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public TrieNode[] getNode() {
        return node;
    }
}


class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.getNode()[c - 'a'] == null) {
                node.getNode()[c - 'a'] = new TrieNode();
                node.getNode()[c - 'a'].ch = c;
            }
            node = node.getNode()[c - 'a'];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        boolean isPresent = false;
        for (int i = 0; i < word.length(); i++) {
            TrieNode nextNode = node != null ? node.getNode()[word.charAt(i) - 'a'] : null;
            if (i == word.length() - 1) {
                if (nextNode != null) {
                    isPresent = nextNode.isEndOfWord();
                }
            }
            node = nextNode;
        }
        return isPresent;
    }


    void print(TrieNode root) {
        for (TrieNode node : root.getNode()) {
            if (node != null) {
                System.out.println(node.ch + " " + node.isEndOfWord);
                print(node);
            }
        }
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.getNode()[c - 'a'] != null) {
                node = node.getNode()[c - 'a'];
            } else {
                return false;
            }
        }

        return true;
    }
}