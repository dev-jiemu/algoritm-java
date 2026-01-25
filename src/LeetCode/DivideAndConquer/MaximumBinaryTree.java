package src.LeetCode.DivideAndConquer;

import src.LeetCode.common.TreeNode;

// https://leetcode.com/problems/maximum-binary-tree/description/?envType=problem-list-v2&envId=stack
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;

        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // 최대값으로 루트
        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = buildTree(nums, start, maxIndex - 1);
        root.right = buildTree(nums, maxIndex + 1, end);

        return root;
    }
}
