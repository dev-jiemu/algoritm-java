package src.LeetCode.Interval;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/summary-ranges/description/?envType=study-plan-v2&envId=top-interview-150
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums.length == 0) return result;

        int start = 0;

        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) { // 끊어짐
                if (start == i-1) {
                    result.add(String.valueOf(nums[start]));
                } else {
                    result.add(nums[start] + "->" + nums[i-1]);
                }

                start = i;
            }

        }

        return result;
    }
}
