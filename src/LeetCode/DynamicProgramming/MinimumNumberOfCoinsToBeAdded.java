package src.LeetCode.DynamicProgramming;

import java.util.Arrays;

// 2952. Minimum Number of Coins to be Added
// https://leetcode.com/problems/minimum-number-of-coins-to-be-added/description/
public class MinimumNumberOfCoinsToBeAdded {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);

        int dp = 0; // 직전값 보관
        int result = 0;
        int i = 0;

        while(dp < target) {
            if (i < coins.length && coins[i] <= dp + 1) {
                dp += coins[i];
                i++;
            } else {
                dp += (dp + 1);
                result++;
            }
        }

        return result;
    }
}
