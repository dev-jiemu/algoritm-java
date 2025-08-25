package src.LeetCode.Hash;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/?envType=study-plan-v2&envId=top-interview-150
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars); // 정렬하면 되지 ㅇㅂㅇ
            String key = String.valueOf(chars);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
