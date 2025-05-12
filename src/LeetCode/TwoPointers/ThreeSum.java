package src.LeetCode.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/description/
public class ThreeSum {
    // 3 <= nums.length <= 3000
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 일단 정렬
        Arrays.sort(nums);

        // index : length - 2 까지
        for (int index = 0; index < nums.length - 2; index++) {
            // 이전꺼랑 같으면 이미 한번 한거임(왜냐면 위에서 데이터 정렬 한번 해서 ㅇㅇ)
            if (index > 0 && nums[index] == nums[index - 1]) continue;

            int left = index + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[index] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[index], nums[left], nums[right]));

                    // 이후 데이터 중복이면 건너뛰기
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
            }
        }

        return result;
    }

}
