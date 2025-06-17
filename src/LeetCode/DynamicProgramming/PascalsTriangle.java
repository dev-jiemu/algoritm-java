package src.LeetCode.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/description/?envType=problem-list-v2&envId=dynamic-programming
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        // index 1
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        if (numRows == 1) {
            return result;
        }

        // index 2
        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        result.add(second);

        if (numRows == 2) {
            return result;
        }

        // index 3 부터 DP
        if (numRows > 2) {
            for(int i = 2; i < numRows; i++) {
                List<Integer> prev = result.get(i - 1);
                List<Integer> next = new ArrayList<>();

                next.add(1);
                for(int j = 1; j <= i - 1; j++)  {
                    next.add(prev.get(j - 1) + prev.get(j));
                }
                next.add(1);

                result.add(next);
            }
        }

        return result;
    }
}
