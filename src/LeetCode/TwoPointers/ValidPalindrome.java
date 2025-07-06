package src.LeetCode.TwoPointers;

// https://leetcode.com/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int ascii = (int) c;

            if (ascii >= 97 && ascii <= 122) {
                sb.append(c);
            } else if (ascii >= 65 && ascii <= 90) { // 대문자면?
                sb.append((char)(ascii + 32));
            } else if (ascii >= 48 && ascii <= 57) {
                sb.append(c);
            }
        }

        String filtered = sb.toString();
        String reversed = sb.reverse().toString();

        return filtered.equals(reversed);
    }
}
