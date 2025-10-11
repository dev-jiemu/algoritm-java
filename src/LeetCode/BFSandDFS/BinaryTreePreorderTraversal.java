package src.LeetCode.BFSandDFS;

import src.LeetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-preorder-traversal/?envType=problem-list-v2&envId=depth-first-search
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    // 전위
    private void preorder(TreeNode node, List<Integer> result) {
        if (node == null) return;

        result.add(node.val);
        preorder(node.left, result);
        preorder(node.right, result);
    }
}
