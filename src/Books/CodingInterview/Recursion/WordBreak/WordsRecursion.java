package src.Books.CodingInterview.Recursion.WordBreak;

import java.util.Set;

// 1. 재귀로 풀어보기
public class WordsRecursion {

    private static boolean breakItPlainRecursive(Set<String> dictionary, String str, int index) {
        if (index == str.length()) {
            return true;
        }

        boolean canBreak = false;

        for(int i = index; i < str.length(); i++) {
            canBreak = canBreak || dictionary.contains(str.substring(index, i + 1)) && breakItPlainRecursive(dictionary, str, i + 1);
        }

        return canBreak;
    }
}
