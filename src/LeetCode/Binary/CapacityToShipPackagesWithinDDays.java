package src.LeetCode.Binary;

// 1011. Capacity To Ship Packages Within D Days
// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for(int weight : weights){
            low = Math.max(low, weight);
            high += weight;
        }

        while(low < high) {
            int mid = (low + high) / 2;
            int needDays = daysNeeded(weights, mid);

            if (needDays <= days) {
                high = mid;
            } else {
                low = mid + 1;
            }

            // 끝나면 low == high
        }

        return low;
    }

    private int daysNeeded(int[] weights, int mid) {
        int result = 1;

        int total = 0;
        for(int i = 0; i < weights.length; i++){
            if (total + weights[i] > mid) { // mid 보다 크거나 같으면 초기화 하고 카운트 올림
                result++;
                total = 0;
            }

            total += weights[i];
        }

        return result;
    }
}
