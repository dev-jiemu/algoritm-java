package src.LeetCode.Math;

// 3876. Construct Uniform Parity Array II
// https://leetcode.com/problems/construct-uniform-parity-array-ii/
public class ConstructUniformParityArrayTwo {
    // j는 위치(앞/뒤) 상관없이 배열 전체에서 값이 더 작기만 하면 되는 조건
    public boolean uniformArray(int[] nums1) {
        // 홀/짝 체크용
        int oddCount = 0;
        int evenCount = 0;
        int min = Integer.MAX_VALUE;

        for(int num : nums1) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
            min = Math.min(min, num);
        }

        if (oddCount == 0 || evenCount == 0) {
            return true;
        }

        return min % 2 != 0;
    }
}
