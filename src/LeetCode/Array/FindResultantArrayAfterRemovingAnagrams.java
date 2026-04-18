package src.LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 2273. Find Resultant Array After Removing Anagrams
// https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/description/
public class FindResultantArrayAfterRemovingAnagrams {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prevSorted = "";

        for (String word : words) {
            String sorted = sortString(word);

            if (!sorted.equals(prevSorted)) {
                result.add(word);
                prevSorted = sorted;
            }
        }

        return result;
    }

    private String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
