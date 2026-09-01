package src.LeetCode.DynamicProgramming;

import java.util.Arrays;

// 96. Unique Binary Search Trees
// https://leetcode.com/problems/unique-binary-search-trees/description/
public class UniqueBinarySearchTrees {
    // 백트래킹으로 푸는건가 했는데 DP 문제였네 ㅇㅂㅇ....
    // 이중 for 문으로도 풀 수 있긴 한데 이미 계산한건 넘어가도 될것 같아서 메모이제이션
    public int numTrees(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); // 방문안함
        return helper(n, memo);
    }

    private int helper(int n, int[] memo) {
        if (n == 0 || n == 1) {
            return 1; // 0또는 1이면 어차피 하나뿐임
        }

        if(memo[n] != -1) { // 계산됨
            return memo[n];
        }

        int count = 0;
        for(int root = 1; root <= n; root++) {
            int left = root - 1;
            int right = n - root;

            count += helper(left, memo) * helper(right, memo);
        }

        memo[n] = count;
        return count;
    }
}
