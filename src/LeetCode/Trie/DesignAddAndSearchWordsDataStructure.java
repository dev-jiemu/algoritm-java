package src.LeetCode.Trie;

// https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
public class DesignAddAndSearchWordsDataStructure {
    private TrieNode root;

    public void WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }

        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return this.searchHelper(word, 0, this.root);
    }

    private boolean searchHelper(String word, int index, TrieNode node) {
        if (node == null) return false;

        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char c = word.charAt(index);

        // '.'을 만났을 때 : 모든 자식 노드 탐색
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if (searchHelper(word, index + 1, node.children[i])) {
                        return true;  // 하나라도 매칭되면 true
                    }
                }
            }

            return false;
        } else {
            int charIndex = c - 'a';
            return searchHelper(word, index + 1, node.children[charIndex]);
        }
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
        children = new TrieNode[26]; // a-z
        isEndOfWord = false;
    }
}
