package src.LeetCode.Binary;

// https://leetcode.com/problems/koko-eating-bananas/description/
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSize = Integer.MIN_VALUE;

        for (int i = 0; i < piles.length; i++) {
            maxSize = Math.max(maxSize, piles[i]);
        }

        int left = 1;
        int right = maxSize;
        while(left < right) {
            int mid = (left + right) / 2;

            long totalHours = 0;
            for(int pile : piles) {
                totalHours += (pile + mid - 1) / mid ;
            }

            if (totalHours <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
