package src.LeetCode.Greedy;

public class MinimumOperationsToTransformArray {
    public long minOperations(int[] nums1, int[] nums2) {
        long answer = 1;
        boolean ok = false; // nums2[n] 을 경로에서 지나치는지?
        int d = Integer.MAX_VALUE;
        int n = nums1.length;

        for (int i = 0; i < n; i++) {
            int min = Math.min(nums1[i], nums2[i]);
            int max = Math.max(nums1[i], nums2[i]);

            answer += max - min; // 기본 증감비용

            if (min <= nums2[n] && nums2[n] <= max) { // 범위 안에 있는지?
                ok = true;
            } else {
                // 범위 밖이면 가장 가까운 끝점까지의 거리 기록 - 만날 수가 없어서 별도로 계산해야함
                d = Math.min(d, Math.min(Math.abs(min - nums2[n]), Math.abs(max - nums2[n])));
            }
        }

        if (!ok) answer += d;
        return answer;
    }
}
