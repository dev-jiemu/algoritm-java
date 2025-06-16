package src.LeetCode.BinarySearch;

import src.LeetCode.common.TreeNode;

// https://leetcode.com/problems/count-complete-tree-nodes/description/?envType=problem-list-v2&envId=binary-search
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        return recursion(root);
    }

    private int recursion(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int count = 1;

        return count = count + recursion(node.left) + recursion(node.right);
    }
}
