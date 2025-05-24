package src.LeetCode.BFSandDFS;

import src.LeetCode.common.TreeNode;

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


    // 2. 재귀로 풀기
    public void flattenRecursion(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) p = p.right; // right 로 이동
        p.right = right;
    }
}
