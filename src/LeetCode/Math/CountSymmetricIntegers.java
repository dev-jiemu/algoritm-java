package src.LeetCode.Math;

// 2843. Count Symmetric Integers
// https://leetcode.com/problems/count-symmetric-integers/description/
public class CountSymmetricIntegers {
    // 1 ~ 10000 까지라서 그냥 for 문 써도 될듯 ㅇㅂㅇ
    public int countSymmetricIntegers(int low, int high) {
        int result = 0;

        for(int i = low; i <= high; i++) {
            String s = String.valueOf(i);

            // 홀수면 건너뜀
            if(s.length() % 2 != 0) {
                continue;
            }

            int mid = s.length() / 2;

            int left = 0;
            int right = 0;

            for (int j = 0; j < mid; j++) {
                left += s.charAt(j) - '0';
                right += s.charAt(j + mid) - '0';
            }

            if (left == right) {
                result++;
            }
        }

        return result;
    }
}
