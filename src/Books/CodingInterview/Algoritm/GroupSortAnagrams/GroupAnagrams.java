package src.Books.CodingInterview.Algoritm.GroupSortAnagrams;

import java.util.*;

public class GroupAnagrams {
    class Anagrams implements Comparator<String> {
        @Override
        public int compare(String word1, String word2) {
            return sortWordChars(word1).compareTo(sortWordChars(word2));
        }
    }

    private final static int RANGE_a_z = 26;

    private static String sortWordChars(String word) {
        char[] wordToChar = word.toCharArray();
        Arrays.sort(wordToChar);

        return String.valueOf(wordToChar);
    }

    // 1. 기본풀이
    public void GroupSortAnagrams(String[] words) {
        Map<String, List<String>> result = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String sorterdWord = sortWordChars(word);

            if (result.containsKey(sorterdWord)) {
                result.get(sorterdWord).add(word);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(word);
                result.put(sorterdWord, anagrams);
            }
        }

        // result
        System.out.println(result.values());
    }

    // 2. 두 애너그램을 비교하는 과정에서 효율적으로 비교하기
    public void GroupSortAnagramsOptimized(String[] words) {
        Map<String, List<String>> result = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] wordToChar = new char[RANGE_a_z];
            
            // 빈도수 계산하기
            for(int j = 0; j < word.length(); j++) {
                wordToChar[word.charAt(j) - 'a']++;
            }

            String computedWord = String.valueOf(wordToChar);

            if (result.containsKey(computedWord)) {
                result.get(computedWord).add(word);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(word);
                result.put(computedWord, anagrams);
            }
        }

        System.out.println(result.values());
    }


}
