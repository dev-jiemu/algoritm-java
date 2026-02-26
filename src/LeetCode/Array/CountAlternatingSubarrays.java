package src.LeetCode.Array;

public class CountAlternatingSubarrays {
    public long countAlternatingSubarrays(int[] nums) {
        int[] len = new int[nums.length];

        len[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                len[i] = len[i - 1] + 1;
            } else {
                len[i] = 1;
            }
        }

        long result = 0;
        for (int l : len) {
            result += l;
        }

        return result;
    }
}
