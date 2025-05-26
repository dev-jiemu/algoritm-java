package src.LeetCode.BinarySearch;

public class SearchInsertPosition {
    // 완전 일치하는경우 말고 중간값도 생각해야하네 ㅇㅂㅇ...
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while(left < right) {
            int mid = (left + right) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
