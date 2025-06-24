package src.LeetCode.Array;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        // 3 이하로 들어올 수도 있을것 같은데
        if (nums.length < 3) {
            return false;
        }

        // nums.length - 3
        // 무족건 연속적으로 들어오란 법이 없네...ㅋㅋㅋ
//        for (int i = 0; i <= nums.length - 3; i++) {
//            if (nums[i] < nums[i + 1] && nums[i + 1] < nums[i + 2]) {
//                return true;
//            }
//        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;
    }
}
