package com.example.algorithm.medium;

import com.example.algorithm.structure.TrieNode;

public class TwoHundredAndEight {

    private TrieNode root;

    public TwoHundredAndEight() {
        root = new TrieNode();
    }

    // 时间复杂度 : O(m)
    // 空间复杂度 : O(m)
    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    // 时间复杂度 : O(m)
    // 空间复杂度 : O(1)
    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }


    // 时间复杂度 : O(m)
    // 空间复杂度 : O(1)
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    // search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }

}
