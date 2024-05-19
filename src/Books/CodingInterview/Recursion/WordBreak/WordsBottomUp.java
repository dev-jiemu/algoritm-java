package src.Books.CodingInterview.Recursion.WordBreak;

import java.util.Set;

// 2. 상향적 접근방법으로 풀어보기
public class WordsBottomUp {
    public static boolean breakItBottomUp(Set<String> dictionary, String str) {
        if (dictionary == null || str == null || dictionary.isEmpty() || str.isEmpty()) {
            return false;
        }

        boolean[] table = new boolean[str.length() + 1];
        table[0] = true;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; table[i] && j <= str.length(); j++) {
                if (dictionary.contains(str.substring(i, j))) {
                    table[j] = true;
                }
            }
        }

        return table[str.length()];
    }
}
