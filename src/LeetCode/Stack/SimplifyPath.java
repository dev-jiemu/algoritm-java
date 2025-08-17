package src.LeetCode.Stack;

import java.util.Stack;

// https://leetcode.com/problems/simplify-path/description/?envType=study-plan-v2&envId=top-interview-150
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if(part.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!part.isEmpty() && !part.equals(".")) {
                stack.push(part);
            }
            // 빈 문자열 건너뛰어도 됨
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }
}
