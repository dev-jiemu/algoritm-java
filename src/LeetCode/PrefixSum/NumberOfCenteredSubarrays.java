package src.LeetCode.PrefixSum;

import java.util.HashSet;
import java.util.Set;

// 3804. Number of Centered Subarrays
// https://leetcode.com/problems/number-of-centered-subarrays/
public class NumberOfCenteredSubarrays {
    // 슬라이딩 윈도우나 투포인터를 생각했는데, total count 가 다르면 포인터를 움직여야하는데 그 움직이는 기준을 잡을수가 없음...ㅇㅂㅇ..
    // = 브루트 포스
    public int centeredSubarrays(int[] nums) {
        int result = 0;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            long total = 0; // 배열 길이 때문에 ㅇㅂㅇ
            Set<Integer> elements = new HashSet<>();
            for(int j = i; j < n; j++){
                total += nums[j];
                elements.add(nums[j]);
                if (elements.contains((int) total)) {
                    result++;
                }
            }
        }

        return result;
    }
}
