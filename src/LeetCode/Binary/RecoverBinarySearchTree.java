package src.LeetCode.Binary;

import src.LeetCode.common.TreeNode;

// 99. Recover Binary Search Tree
// https://leetcode.com/problems/recover-binary-search-tree/description/
public class RecoverBinarySearchTree {
    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        if(prev != null && prev.val > node.val) {
            if (first == null) { // 첫번째 깨짐
                first = prev;
            }
            second = node; // second 는 항상 갱신함
        }

        prev = node; // 탐색종료
        inorder(node.right);
    }
}
