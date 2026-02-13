package src.LeetCode.String;

// https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/description/
public class CheckIfNumbersAreAscendingInASentence {
    public boolean areNumbersAscending(String s) {
        String[] tokens = s.split(" ");
        int prev = -1;

        for(String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                int num = Integer.parseInt(token);
                if (num <= prev) {
                    return false;
                }
                prev = num;
            }
        }

        return true;
    }
}
