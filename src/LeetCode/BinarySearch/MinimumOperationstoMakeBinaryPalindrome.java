package src.LeetCode.BinarySearch;

// https://leetcode.com/problems/minimum-operations-to-make-binary-palindrome/description/
public class MinimumOperationstoMakeBinaryPalindrome {
    public int[] minOperations(int[] nums) {
        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            answer[i] = findMinOps(nums[i]);
        }

        return answer;
    }

    private int findMinOps(int num) {
        if (isPalindrome(num)) return 0;

        // 위 아래로 가장 가까운 회문 찾기
        int up = num + 1;
        int down = num - 1;

        while (!isPalindrome(up)) up++;
        while (down > 0 && !isPalindrome(down)) down--;

        // 더 가까운 쪽
        int upDist = up - num;
        int downDist = (down > 0) ? num - down : Integer.MAX_VALUE;

        return Math.min(upDist, downDist);
    }

    private boolean isPalindrome(int num) {
        String binary = Integer.toBinaryString(num);
        int left = 0, right = binary.length() - 1;

        while (left < right) {
            if (binary.charAt(left) != binary.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
