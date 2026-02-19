package src.LeetCode.Hash;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();

        // s 개수 세기
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 이중 for문 같아서 O^2 같지만 O(m + n)임
        for (char c : order.toCharArray()) {
            if (map.containsKey(c)) {
                int cnt = map.get(c);
                for(int i = 0; i < cnt; i++) {
                    sb.append(c);
                }
                map.remove(c);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int cnt = entry.getValue();
            for (int i = 0; i < cnt; i++) sb.append(entry.getKey());
        }

        return sb.toString();
    }
}
