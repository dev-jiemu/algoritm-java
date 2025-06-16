package src.LeetCode.BFSandDFS;

import src.LeetCode.common.TreeNode;

// https://leetcode.com/problems/count-good-nodes-in-binary-tree/?envType=study-plan-v2&envId=leetcode-75
public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }

        int count = node.val >= max ? 1 : 0;
        int newMax = Math.max(max, node.val);

        return count + dfs(node.left, newMax) + dfs(node.right, newMax);
    }
}
