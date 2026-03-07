package src.LeetCode.Hash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/replace-words/
public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dictSet = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            for (int len = 1; len <= words[i].length(); len++) {
                String prefix = words[i].substring(0, len);
                if (dictSet.contains(prefix)) {
                    words[i] = prefix;
                    break;
                }
            }
        }

        return String.join(" ", words);
    }

    /*
    Trie 로 할 수 있긴 함 ㅇㅇ 이게 더 빠르긴 한데...ㅇㅂㅇ..
    public class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String root = null;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode trie = new TrieNode();
        for (String root : dictionary) {
            TrieNode node = trie;
            for (char c : root.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null)
                    node.children[idx] = new TrieNode();
                node = node.children[idx];
            }
            node.root = root;
        }

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            TrieNode node = trie;
            for (char c : words[i].toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) break; // prefix 없음
                node = node.children[idx];
                if (node.root != null) {              // prefix 발견!
                    words[i] = node.root;
                    break;
                }
            }
        }

        return String.join(" ", words);
    }
     */
}
