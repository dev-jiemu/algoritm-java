package src.LeetCode.Array;

import java.util.Arrays;

// https://leetcode.com/problems/sorting-the-sentence/description/
public class SortingTheSentence {
    public String sortSentence(String s) {
        String[] words = s.split(" ");

        Arrays.sort(words, (a, b) ->
                a.charAt(a.length() - 1) - b.charAt(b.length() - 1)
        );

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word, 0, word.length() - 1); // 뒤에 숫자 뺌
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    /*
     * string 순서 자체를 인덱스로 잡는것도 괜찮네 ㅇㅂㅇ
     * String[] rez = new String[words.length];

        for (String w : words) {
            rez[w.charAt(w.length() - 1) - '1'] = w.substring(0, w.length() - 1);
        }
     */
}
