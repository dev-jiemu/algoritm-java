package src.BinarySearch;

// https://leetcode.com/problems/koko-eating-bananas/?envType=study-plan-v2&envId=leetcode-75
public class KokoEatingBananas {
    // TODO : retry
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while(left < right) {
            int mid = (left + right) / 2;

            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFinish(int[] piles, int k, int h) {
        int totalTime = 0;

        for (int pile : piles) {
            // 각 더미를 먹는데 필요한 시간 계산
            // 예: pile=11, k=4 → 시간 = (11+4-1)/4 = 14/4 = 3시간
            totalTime += (pile + k - 1) / k;  // 올림 계산

            if (totalTime > h) {
                return false;
            }
        }

        return totalTime <= h;
    }
}
