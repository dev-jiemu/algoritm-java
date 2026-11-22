package src.LeetCode.Math;

// 4076. Longest Resilient Subarray II
// https://leetcode.com/problems/longest-resilient-subarray-ii/description/
public class LongestResilientSubarrayTwo {
    // 각 원소를 k로 나눈 나머지로 바꾸면, 같은 나머지끼리 연속된 구간이 생김
    // r·(cnt-1) ≡ 0 (mod k)
    public int resilientSubarray(int[] nums, int k) {
        int answer = 1;
        int n = nums.length;

        int i = 0;
        while(i < n) {
            int r = nums[i] % k;

            // 같은 나머지 구간 찾기
            int j = i;
            while(j < n && nums[j] % k == r) {
                j++;
            }

            int m = j - i;

            // (L-1) * r ≡ 0 (mod k)
            int g = gcd(r, k);
            int step = k / g;
            int l = ((m - 1) / step) * step + 1;

            answer = Math.max(answer, l);
            i = j;
        }

        return answer;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
