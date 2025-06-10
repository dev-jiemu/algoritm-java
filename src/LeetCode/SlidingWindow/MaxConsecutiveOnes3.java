package src.LeetCode.SlidingWindow;

public class MaxConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        int result = 0;
        int start = 0; // 0의 개수가 k개를 초과하면 포인터 이동 해야함
        int end = 0;

        int zeroCnt = 0;
        while(end < nums.length) {

            if (nums[end] == 0) {
                zeroCnt++;
            }

            end++;

            if (zeroCnt > k) {
                while (zeroCnt > k) {
                    if (nums[start] == 0) {
                        zeroCnt--;
                    }
                    start++;
                }
            }

            result = Math.max(result, end - start);
        }

        return result;
    }
}
