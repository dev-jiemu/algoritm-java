package src.LeetCode.Array;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
public class RemoveDuplicatesfromSortedArrayTwo {
    public int removeDuplicates(int[] nums) {
        int writePos = 0;
        int count = 1;

        nums[writePos++] = nums[0];

        for(int readPos = 1; readPos < nums.length; readPos++) {
            if(nums[readPos] == nums[readPos-1]) {
                count++;
            } else {
                count = 1;
            }

            if(count <= 2) {
                nums[writePos++] = nums[readPos];
            }
        }

        return writePos;
    }
}
