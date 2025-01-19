package src.Books.CodingInterview.StackAndQueue.StackBraces;

import java.util.Stack;

public class StackBraces {
    public static boolean bracesMatching(String str) {
        Stack<Character> stack = new Stack<>();
        int len = str.length();

        for(int i = 0; i < len; i++) {
            if(str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == '}') {
                if (stack.isEmpty()) { return false; }
                stack.pop();
            } else {
                return false; // error
            }
        }

        return stack.isEmpty();
    }
}
