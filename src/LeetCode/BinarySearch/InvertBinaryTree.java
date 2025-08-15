package src.LeetCode.BinarySearch;

import src.LeetCode.common.TreeNode;

// https://leetcode.com/problems/invert-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        return invertTreeRecursion(root);
    }

    private TreeNode invertTreeRecursion(TreeNode tree) {
        if (tree == null) {
            return null;
        }

        TreeNode left = invertTreeRecursion(tree.right);
        TreeNode right = invertTreeRecursion(tree.left);

        tree.left = left;
        tree.right = right;

        return tree;
    }
}
