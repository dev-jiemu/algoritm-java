package src.LeetCode.Array;

// 2496. Maximum Value of a String in an Array
// https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/description/
public class MaximumValueOfAStringInAnArray {
    public int maximumValue(String[] strs) {
        int result = 0;

        for (String str : strs) {
            int value = isNumeric(str) ? Integer.parseInt(str) : str.length();
            result = Math.max(result, value);
        }

        return result;
    }

    private boolean isNumeric(String s) {
        for(char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}
