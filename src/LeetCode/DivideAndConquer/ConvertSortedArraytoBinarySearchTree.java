package src.LeetCode.DivideAndConquer;

import src.LeetCode.common.TreeNode;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/submissions/1713349231/?envType=study-plan-v2&envId=top-interview-150
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return binaryTree(nums, 0, nums.length - 1);
    }

    // 반절씩
    private TreeNode binaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = binaryTree(nums, left, mid - 1);
        root.right = binaryTree(nums, mid + 1, right);

        return root;
    }
}
