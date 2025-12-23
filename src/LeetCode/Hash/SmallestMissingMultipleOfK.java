package src.LeetCode.Hash;

import java.util.HashSet;

// https://leetcode.com/problems/smallest-missing-multiple-of-k/description/
public class SmallestMissingMultipleOfK {
    // 무한정 k를 늘릴수는 없으니까 nums 배열 내에 최대값을 찾고 그거 기준으로만 돌리는게 나을듯
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int maxNum = 0;

        // nums 저장하면서 최댓값도 추적
        for (int num : nums) {
            set.add(num);
            maxNum = Math.max(maxNum, num);
        }

        for (int i = 1; i <= maxNum/k + 1; i++) {
            if (!set.contains(i * k)) {
                return i * k;
            }
        }

        // maxNum보다 큰 첫 번째 k의 배수
        return ((maxNum / k) + 1) * k;
    }
}
