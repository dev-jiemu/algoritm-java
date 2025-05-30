package src.LeetCode.Array;

import java.util.ArrayList;

// https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=leetcode-75
public class ReverseWordsinaString {
    public String reverseWords(String s) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        String[] words = s.split(" ");
        for(String word : words) {
            if (!word.trim().isEmpty()) {
                list.add(word);
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            result.append(list.get(i));
            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
