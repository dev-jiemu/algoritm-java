package src.LeetCode.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/?envType=problem-list-v2&envId=dynamic-programming
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateDp(n, result, "", 0, 0);
        return result;
    }

    private void generateDp(int n, List<String> list, String prev, int left, int right) {
        if (prev.length() == (n * 2)) {
            list.add(prev);
            return;
        }

        if (left < n) {
            generateDp(n, list, prev + "(", left + 1, right);
        }

        if (left > right) {
            generateDp(n, list, prev + ")", left, right + 1);
        }
    }
}
