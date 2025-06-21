package src.LeetCode.BFSandDFS;

import src.LeetCode.common.TreeNode;

// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75
public class LongestZigZagPathinaBinaryTree {
    private int maxLength = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;

        helper(root.left, 1, true);   // 루트에서 왼쪽 자식으로 시작
        helper(root.right, 1, false); // 루트에서 오른쪽 자식으로 시작

        return maxLength;
    }

    private void helper(TreeNode node, int length, boolean isLeft) {
        if (node == null) return;

        maxLength = Math.max(maxLength, length);

        if (isLeft) {
            helper(node.right, length + 1, false);
            helper(node.left, 1, true);
        } else {
            helper(node.left, length + 1, true);
            helper(node.right, 1, false);
        }
    }
}
