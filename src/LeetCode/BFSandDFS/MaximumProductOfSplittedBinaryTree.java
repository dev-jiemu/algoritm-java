package src.LeetCode.BFSandDFS;

import src.LeetCode.common.TreeNode;

// 1339. Maximum Product of Splitted Binary Tree
// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/
public class MaximumProductOfSplittedBinaryTree {
    private long total = 0;
    private long result = 0;
    private static final int MOD = 1_000_000_007; // 모듈로

    public int maxProduct(TreeNode root) {
        this.total = this.getSum(root);
        this.postorderSum(root);
        return (int) (this.result % MOD);
    }

    private long getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + getSum(node.left) + getSum(node.right);
    }

    private long postorderSum(TreeNode node) {
        if(node == null) {
            return 0;
        }

        long leftSum = postorderSum(node.left);
        long rightSum = postorderSum(node.right);
        long subtreeSum = leftSum + rightSum + node.val;

        // subtreeSum * (total - subtreeSum) 을 계산해서 최대값인지 확인하기
        this.result = Math.max(this.result, subtreeSum * (total - subtreeSum));

        return subtreeSum;
    }
}
