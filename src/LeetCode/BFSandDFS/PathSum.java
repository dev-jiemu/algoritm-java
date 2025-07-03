package src.LeetCode.BFSandDFS;

import src.LeetCode.common.TreeNode;

// https://leetcode.com/problems/path-sum/?envType=problem-list-v2&envId=breadth-first-search
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // 리프 노드에 도달했을 때 확인
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}
