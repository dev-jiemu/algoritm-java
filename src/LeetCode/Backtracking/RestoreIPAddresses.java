package src.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

// 93. Restore IP Addresses
// https://leetcode.com/problems/restore-ip-addresses/description/
public class RestoreIPAddresses {
    private List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, int start, List<String> parts) {
        if (parts.size() == 4 && start == s.length()) {
            result.add(String.join(".", parts));
            return;
        }

        // 4파트 초과
        if(parts.size() == 4 || start == s.length()) {
            return;
        }

        for(int len = 1; len <= 3; len++) {
            if(start + len > s.length()) {
                break;
            }

            String seg = s.substring(start, start + len);

            // 선행 0
            if (seg.length() > 1 && seg.charAt(0) == '0') {
                break;
            }

            // 255 체크
            if(Integer.parseInt(seg) > 255) {
                break;
            }

            parts.add(seg);
            backtrack(s, start + len, parts);
            parts.remove(parts.size() - 1);
        }
    }
}
