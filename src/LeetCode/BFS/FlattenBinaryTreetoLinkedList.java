package src.LeetCode.BFS;

import src.LeetCode.BFS.common.TreeNode;

import java.util.Stack;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/submissions/1634173176/?envType=problem-list-v2&envId=depth-first-search
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }

            if (prev != null) {
                prev.right = current;
                prev.left = null;
            }

            prev = current;
        }
    }
}
