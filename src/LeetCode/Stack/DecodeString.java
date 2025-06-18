package src.LeetCode.Stack;

import java.util.Stack;

// https://leetcode.com/problems/decode-string/?envType=study-plan-v2&envId=leetcode-75
public class DecodeString {
    /*
        Input: s = "3[a]2[bc]"
        Output: "aaabcbc"
     */
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> words = new Stack<>();

        int currentCount = 0;
        String currentString = "";

        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);

            if (current == '['){
                if (currentCount > 0) {
                    nums.push(currentCount);
                    currentCount = 0;
                }
                words.push(currentString);
                currentString = "";
            } else if (Character.isDigit(current)) {
                // 자릿수 올림
                currentCount = currentCount * 10 + (current - '0');
            } else if (Character.isLetter(current)) {
                currentString = currentString + current;
            } else if (current == ']'){
                if (!nums.isEmpty()) {
                    int currentNum = nums.pop();
                    String prevString = words.pop();

                    currentString = prevString + currentString.repeat(currentNum);
                }
            }
        }

        return currentString;
    }
}
