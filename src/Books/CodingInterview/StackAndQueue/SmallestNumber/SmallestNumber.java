package src.Books.CodingInterview.StackAndQueue.SmallestNumber;

import java.util.Stack;

public class SmallestNumber {
    public static void smallestAfterRemove(String n, int k) {
        int i = 0;
        
        Stack<Character> stack = new Stack<>();
        
        while(i < n.length()) {
            while(k > 0 && !stack.isEmpty() && stack.peek() > n.charAt(i)) {
                stack.pop(); // 현재 자리 숫자가 이전 자리 숫자보다 작으면 버림
                k--;
            }
            
            stack.push(n.charAt(i));
            i++;
        }

        // 숫자가 같을경우 ㅇㅂㅇ...
        while(k > 0) {
            stack.pop();
            k--;
        }
    }
}
