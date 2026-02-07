package src.LeetCode.PrefixSum;

// https://leetcode.com/problems/range-sum-query-immutable/description/?envType=problem-list-v2&envId=prefix-sum
public class RangeSumQueryImmutable {
    private int[] prefixSum;

    public RangeSumQueryImmutable(int[] nums) {
       this.prefixSum = new int[nums.length + 1];
       for(int i = 0; i < nums.length; i++) {
           // DP 같네 ㅇㅂㅇ (+메모이제이션)
           // 이전 결과 + 현재 값
           this.prefixSum[i + 1] = prefixSum[i] + nums[i];
       }
    }

    public int sumRange(int left, int right) {
        return this.prefixSum[right + 1] - this.prefixSum[left];
    }
}
