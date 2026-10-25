package src.LeetCode.TwoPointers;

// 925. Long Pressed Name
// https://leetcode.com/problems/long-pressed-name/description/
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int left = 0;
        for(int right = 0; right < typed.length(); right++){
            if (left < name.length() && typed.charAt(right) == name.charAt(left)){
                left++;
            } else if (right > 0 && typed.charAt(right) == typed.charAt(right-1)){
                // continue
            } else {
                return false;
            }
        }

        return left == name.length();
    }
}
