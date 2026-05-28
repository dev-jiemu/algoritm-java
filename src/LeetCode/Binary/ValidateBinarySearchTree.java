package src.LeetCode.Binary;

import src.LeetCode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

// 98. Validate Binary Search Tree
// https://leetcode.com/problems/validate-binary-search-tree/description/
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        // 근거 문서가 필요한데, Stack 사용 보다 Deque 사용을 더 권장한다고 함
        Deque<TreeNode> stack = new ArrayDeque<>();
        long prev = Long.MIN_VALUE;
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if (curr.val <= prev) {
                return false;
            }

            prev = curr.val;
            curr = curr.right;
        }

        return true;
    }
}
