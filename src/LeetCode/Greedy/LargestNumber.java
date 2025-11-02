package src.LeetCode.Greedy;

import java.util.Arrays;

// https://leetcode.com/problems/largest-number/?envType=problem-list-v2&envId=greedy
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);  // 내림차순
        });

        // 내림차순으로 정렬하니까 0이 맨 앞이면 그 뒷 요소들도 전부 0임
        if(strs[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            result.append(str);
        }

        return result.toString();
    }
}
