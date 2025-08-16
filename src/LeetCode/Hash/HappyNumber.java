package src.LeetCode.Hash;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while (n != 1) {
            // 이미 본 숫자면 무한루프로 간주함
            if (seen.contains(n)) {
                return false;
            }

            seen.add(n);
            n = getSumOfSquares(n);
        }

        return true;
    }

    private int getSumOfSquares(int n) {
        int sum = 0;

        while(n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}
