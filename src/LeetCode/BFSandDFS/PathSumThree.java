package src.LeetCode.BFSandDFS;

import src.LeetCode.common.TreeNode;

// https://leetcode.com/problems/path-sum-iii/description/?envType=study-plan-v2&envId=leetcode-75
public class PathSumThree {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        return pathSumRecursion(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int pathSumRecursion(TreeNode node, long targetSum) {
        if (node == null) return 0;

        int count = 0;
        if (node.val == targetSum) count++;

        count += pathSumRecursion(node.left, targetSum - node.val);
        count += pathSumRecursion(node.right, targetSum - node.val);

        return count;
    }
}
