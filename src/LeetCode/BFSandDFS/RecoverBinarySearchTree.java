package src.LeetCode.BFSandDFS;

import src.LeetCode.common.TreeNode;

// https://leetcode.com/problems/recover-binary-search-tree/description/?envType=problem-list-v2&envId=depth-first-search
public class RecoverBinarySearchTree {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null; // 이전 노드 비교용

    public void recoverTree(TreeNode root) {
        this.inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        // 현재 노드가 이전 노드보다 작으면 깨진거임
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }

        prev = node;

        inorder(node.right);
    }
}
