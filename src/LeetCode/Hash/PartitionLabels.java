package src.LeetCode.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/partition-labels/description/?envType=problem-list-v2&envId=greedy
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex.get(s.charAt(i))); // 현재 문자와 마지막 위치 중 큰값

            if(i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}
