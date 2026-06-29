package src.LeetCode.TwoPointers;

import java.util.Arrays;

// 825. Friends Of Appropriate Ages
// https://leetcode.com/problems/friends-of-appropriate-ages/
public class FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        int result = 0;

        // 일단 정렬 다시해둠
        Arrays.sort(ages);

        int left = 0;
        int right = 0;

        for (int i = 0; i < ages.length; i++) {
            int x = ages[i];

            while(left < ages.length && ages[left] <= 0.5 * x + 7) {
                left++;
            }

            while(right + 1 < ages.length && ages[right + 1] <= x) {
                right++;
            }

            if (right > left) {
                result += (right - left);
            }
        }

        return result;
    }
}
