package src.LeetCode.Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/first-unique-character-in-a-string/?envType=problem-list-v2&envId=queue
public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();  // 등장 횟수 저장
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            countMap.put(cur, countMap.getOrDefault(cur, 0) + 1);

            if (countMap.get(cur) == 1) {
                queue.offer(new int[]{cur, i});
            }
        }

        while(!queue.isEmpty()) {
            int[] front = queue.peek();
            char ch = (char)front[0];
            int idx = front[1];

            if(countMap.get(ch) == 1) {
                return idx;
            }

            queue.poll();
        }

        return -1;
    }
}
