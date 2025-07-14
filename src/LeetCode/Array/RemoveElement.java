package src.LeetCode.Array;

// https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                continue;
            } else {
                nums[idx] = nums[i];
                idx++;
            }
        }

        return idx;
    }
}
