package src.LeetCode.SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-harmonious-subsequence/description/?envType=problem-list-v2&envId=sliding-window
public class LongestHarmoniousSubsequence {
    // 등장횟수 세면 되려나
    public int findLHS(int[] nums) {
        int maxLength = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                int currentLength = map.get(num) + map.get(num + 1);
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    // 근데 본디 주제가 슬라이딩 윈도우니까 주제 살려서 풀면
    public int findLHSSliding(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            while(nums[right] - nums[left] > 1) {
                left++;
            }

            if (nums[right] - nums[left] == 1) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }
}
