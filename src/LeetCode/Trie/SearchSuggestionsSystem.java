package src.LeetCode.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/search-suggestions-system/submissions/1690760273/?envType=study-plan-v2&envId=leetcode-75
public class SearchSuggestionsSystem {
    class TrieNode {
        TrieNode[] children = new TrieNode[26]; // a ~ z
        List<String> suggestions = new ArrayList<>();
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();

        Arrays.sort(products);

        for (String product : products) {
            TrieNode current = root;

            for (char c : product.toCharArray()) {
                int index = c - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];

                if (current.suggestions.size() < 3) {
                    current.suggestions.add(product);
                }
            }
        }

        List<List<String>> result = new ArrayList<>();

        // search
        TrieNode current = root;
        for(char c : searchWord.toCharArray()) {
            int index = c - 'a';

            if(current == null || current.children[index] == null) {
                current = null; // 탐색 종료
                result.add(new ArrayList<>());
            } else {
                current = current.children[index];
                result.add(new ArrayList<>(current.suggestions));
            }
        }

        return result;
    }
}
