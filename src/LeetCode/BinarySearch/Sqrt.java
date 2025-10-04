package src.LeetCode.BinarySearch;

// https://leetcode.com/problems/sqrtx/description/?envType=problem-list-v2&envId=binary-search
public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 0;
        int right = x;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 오버플로우 주의 : mid * mid > Integer.MAX_VALUE 가 될수도 있음.... mid < x / mid 로 비교
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
