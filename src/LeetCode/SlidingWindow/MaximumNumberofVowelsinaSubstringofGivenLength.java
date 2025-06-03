package src.LeetCode.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75
public class MaximumNumberofVowelsinaSubstringofGivenLength {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');


        int count = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }

        int maxVowels = count;
        for(int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }

            if (vowels.contains(s.charAt(i - k))) {
                count--;
            }

            maxVowels = Math.max(maxVowels, count);
        }

        return maxVowels;
    }
}
