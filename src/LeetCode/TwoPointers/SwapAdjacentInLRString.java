package src.LeetCode.TwoPointers;

public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String result) {
        // start.length == result.length
        int length = start.length();

        int left = 0;
        int right = 0;

        while (left < length && right < length) {
            while(left < length && start.charAt(left) == 'X') left++;
            while(right < length && result.charAt(right) == 'X') right++;

            if(left == length && right == length) {
                return true;
            }

            // 하나만 끝난거면 안맞는거임
            if (left == length || right == length) {
                return false;
            }

            if(start.charAt(left) != result.charAt(right)) {
                return false;
            }

            // start left가 result의 right 보다 작으면 안됨
            if (start.charAt(left) == 'L' && left < right) {
                return false;
            }

            // start의 left가 result의 right 보다 크면 안됨
            if (start.charAt(left) == 'R' && left > right) {
                return false;
            }

            left++;
            right++;
        }

        while (left < length) {
            if (start.charAt(left) != 'X') return false;
            left++;
        }
        while (right < length) {
            if (result.charAt(right) != 'X') return false;
            right++;
        }

        return true;
    }
}
