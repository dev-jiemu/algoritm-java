package src.LeetCode.Array;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();

        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        for (int i = 0; i < word1.length(); i++) {
            queue1.add(word1.substring(i, i + 1));
        }

        for (int i = 0; i < word2.length(); i++) {
            queue2.add(word2.substring(i, i + 1));
        }

        while(queue1.size() > 0 || queue2.size() > 0) {
            String temp1 = queue1.poll();
            String temp2 = queue2.poll();

            if (temp1 != null) {
                result.append(temp1);
            }

            if (temp2 != null) {
                result.append(temp2);
            }
        }

        return result.toString();
    }

    // 생각해보니 둘중 하나가 길이가 짧으면 그거 먼저 하고 나머지 뒤에 붙여도 됐었네 ㅇㅂㅇ..
    public String mergeAlternatelyMost(String word1, String word2) {
        StringBuilder result = new StringBuilder();

        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();

        int smallLength = Math.min(char1.length, char2.length);
        for (int i = 0; i < smallLength; i++) {
            result.append(char1[i]);
            result.append(char2[i]);
        }

        int largeLength = Math.max(char1.length, char2.length);

        for(int j = smallLength; j < largeLength; j++) {
            if (char1.length > char2.length) {
                result.append(char1[j]);
            } else {
                result.append(char2[j]);
            }
        }

        return result.toString();
    }
}
